package com.personnel.action.home;

import java.nio.channels.SeekableByteChannel;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;

import com.personnel.action.mysupport.MyActionSupport;
import com.personnel.bean.user.Checkin;
import com.personnel.bean.user.UserInfo;
import com.personnel.dao.ICheckinDao;
import com.personnel.utils.StrUtils;

/**
 * 用于考勤的相关操作
 * 
 * @author zhouzhenjiang
 * 
 *         打卡的逻辑： 要先获取到周几和当前月数 如果是第一次打卡，就记录到上午打卡记录，并把flag改为1
 *         如果flag为1的话，则将后面的打卡记录计算到晚上打卡记录 查询的每月的记录，所以一共有12张打卡记录表，用户可以按月进行查询考勤记录
 */
public class CheckinAction extends MyActionSupport {

	private ICheckinDao checkinDao;

	public void setCheckinDao(ICheckinDao checkinDao) {
		this.checkinDao = checkinDao;
	}

	@Override
	public String execute() throws Exception {

		String action = request.getParameter("action");

		String result = null;

		if (action != null && !"".equals(action)) {
			if ("daka".equals(action)) {
				result = checkCard();
			} else if ("list".equals(action)) {
				// 获取列表
				result = getCheckinListForMonth();
			}
		}
		return result;
	}

	/**
	 * 获取搜索月的考勤记录
	 * 
	 * @return
	 */

	private String getCheckinListForMonth() {
		// 默认获取当前月份
		Calendar calendar = Calendar.getInstance();
		// 获取当前的月份
		int month = calendar.get(Calendar.MONTH) + 1;
		// 前台如果传来参数我们也
		String monthStr = request.getParameter("month");
		if (monthStr == null) {
			monthStr = month < 10 ? "0" + month : month + "";
		}
		String type = request.getParameter("type");

		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("loginUser");
		List<Checkin> checkinList = checkinDao.getAllByUser(
				userInfo.getEmail(), monthStr);
		session.setAttribute("checkinList", checkinList);
		session.setAttribute("month", monthStr);
		logger.info("###########" + month);
		if (type != null && "sync".equals(type)) {
			// 进行异步提交
			logger.info("进行了异步操作");
			return null;
		} else {
			// 进行同步提交
			logger.info("进行了同步操作");
			return "listview";
		}

	}

	/**
	 * 打卡操作
	 * 
	 * @return
	 */
	private String checkCard() {
		Calendar calendar = Calendar.getInstance();
		// 获取当前的月份
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_YEAR);
		// 获取当前月份数
		String monthStr = month < 10 ? "0" + month : month + "";
		// 获取当前对象
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("loginUser");
		session.setAttribute("menuLevel", 3);

		session.setAttribute("month", month);
		logger.info("*********" + month);

		boolean isExist = checkinDao.isExistForEmail(userInfo.getEmail(),
				monthStr, day) > 0 ? true : false;
		int update = -1;
		if (isExist) {
			// 如果不为空，则说明有打开记录，执行更新操作
			// 获取对应的Checkin对象
			Checkin checkin = checkinDao.getCheckinByEmail(userInfo.getEmail(),
					monthStr, day);
			if (checkin != null) {
				checkin.setCheck_night(new Timestamp(System.currentTimeMillis()));
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				if (StrUtils.nightTimestamp()) {
					checkin.setNight_status("早退");
				} else {
					checkin.setNight_status("正常");
				}
				// 调用更新
				update = checkinDao.updateCheckin(checkin, monthStr);
				Checkin currCheeckin = checkinDao.getCheckinByEmail(userInfo.getEmail(),
						monthStr, day); 
				setDayStatus(currCheeckin, monthStr);
			}
		} else {
			// 如果为空就执行插入操作
			Checkin checkin = new Checkin();
			checkin.setEmail(userInfo.getEmail());

			if (StrUtils.morningTimestamp()) {
				checkin.setMorning_status("迟到");
			} else {
				checkin.setMorning_status("正常");
			}
			checkin.setCheck_morning(new Timestamp(System.currentTimeMillis()));
			checkin.setFlag(1);
			checkin.setWeekday(day);
			update = checkinDao.save(checkin, monthStr);
			Checkin currCheeckin = checkinDao.getCheckinByEmail(userInfo.getEmail(),
					monthStr, day); 
			setDayStatus(currCheeckin, monthStr);

		}

		return update > 0 ? SUCCESS : ERROR;
	}

	/**
	 * 执行查询操作的时候，判断一天的总状态,目前不采用弹性工作的状态， 只要存在一个异常状态，我们就标记的总的为异常
	 * 
	 * @param checkin
	 *            获取指定的值
	 */
	private void setDayStatus(Checkin checkin,String month) {

		if (checkin.getMorning_status() == null
				|| checkin.getNight_status() == null||checkin.getMorning_status().equals("")
				|| checkin.getNight_status().equals("")
				) {
			//不做任何处理
			return ;
		}
		
		if(checkin.getMorning_status().equals("异常")||checkin.getNight_status().equals("异常")){
			//标记为异常
			checkin.setStatus("异常");
			checkinDao.updateCheckin(checkin, month);
			
		}else{
			//标记为正常
			checkin.setStatus("正常");
			checkinDao.updateCheckin(checkin, month);
		}

	}
}
