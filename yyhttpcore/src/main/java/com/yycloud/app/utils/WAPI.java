package com.yycloud.app.utils;

import android.content.Context;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @project name：yyhttpcore
 * @type name：WAPI
 * @description：
 * @author：gang
 * @date time：2017-6-3 下午4:09:33
 */
public class WAPI {
    private static final String TAG = "WAPI";
    // v3产品服务器
    // public static String WAPI_IP = "test.www.yunyangdata.com";
    //public static String WAPI_IP = "59.110.54.8";
//    public static String WAPI_IP = "192.168.3.16";//http://192.168.3.128:8080/jeecg/  http://uatcapi.yunyangdata.com:8080/capi/
    public static String WAPI_IP = "capi.yunyangdata.com";
    // public static String WAPI_TOW_IP = "192.168.3.14";
    //public static String WAPI_TOW_IP = "182.92.67.74";
    public static String WAPI_TOW_IP = "yycloud.yunyangdata.com";

    public static final String WAPI_HTTP_BASE = "http://" + WAPI_IP;

    // v3产品服务器端口
//    public static String WAPI_HTTP_PORT = "9080";
    public static String WAPI_HTTP_PORT = "8080";

    //工程名
//    public static String PROJECTNAME = "cpms";// 项目名称
//      public static String PROJECTNAME = "jeecg";// 项目名称/
    public static String PROJECTNAME = "capi";// 项目名称
    public static final String WAPI_HTTP_URL = WAPI_HTTP_BASE + ":"
            + WAPI_HTTP_PORT;
    public static final String WAPI_USER_URL = WAPI_HTTP_URL + "/api/users";
    public static final String WAPI_URL = WAPI_HTTP_URL + "/api";
    public static final String ccp_token = "ccp_token-smartgate-20150201";
    public static final String CMD_ERELAY_SWITCH = "set_eralay_switch"; // 普通单继电器
    public static final String CMD_CONTROL_RELAY_BOX = "set_relay_switch";
    public static final String CMD_ERELAY2_SWITCH = "set_eralay2_switch"; // 双继电器，卷帘机
    public static final String CMD_ERELAY2_CONFIG = "set_eralay2_config"; // 放风机配置


    public static final String WAPI_HTTP_TOW_BASE = "http://" + WAPI_TOW_IP;
    public static final String WAPI_HTTP_IO = "http://" + WAPI_TOW_IP + ":" + 3000;//socket
    public static final int SERVER_PORT = 80;
    public static final String WAPI_HTTP_TOW_PORT = WAPI_HTTP_TOW_BASE + ":" + SERVER_PORT;//加端口
    public static final String WAPI_TOW_URL = WAPI_HTTP_TOW_PORT + "/api";
    public static final String WAPI_USER_TOW_URL = WAPI_HTTP_TOW_PORT + "/api/users";


    public static final String WAPI_GET_VERSION_URL = WAPI_HTTP_URL
            + "checkversion.php?client=android";
    // /enddevices/sn/info
    /*
     * 报警默认策略
	 */
    public static final String DEFAULT_ALARM_STRATEGY_URL = "/default_alarmstrategies";
    public static final String CUSTOM_ALARM_STRATEGY_URL = "/custom_alarmstrategies/";

    public static final String WAPI_DEFAULT_ALARM_STRATEGY_URL = WAPI_TOW_URL
            + DEFAULT_ALARM_STRATEGY_URL;
    public static final String WAPI_CUSTOM_ALARM_STRATEGY_URL = WAPI_USER_TOW_URL
            + CUSTOM_ALARM_STRATEGY_URL;

    public static final String USER_STRATEGYSETTINGS_URL = "/alarmstrategy_settings/";

    /*
     * 事件 Event
     */
    public static final String ALARMEVENTS_URL = "/alarmevents";

    public static final String USER_ALARMEVENTS_URL = WAPI_USER_TOW_URL
            + ALARMEVENTS_URL;

    public static final String WAPI_ANALYSES_HISTORIES_URL = WAPI_HTTP_URL
            + "/api/analyses/histories";

    public static final String SMARTGATE_URL = "/smartgates/";
    public static final String ENDDEVICE_URL = "/enddevices/";

    public static final String SMSCODE_URL = "/smscodes";
    public static final String PASSWORD_URL = "/passwords";
    public static final String INFO_URL = "/infos";
    public static final String ALIAS_URL = "/alias";
    public static final String NICKNAME_URL = "/nicknames";
    public static final String CONTACT_URL = "/contacts";
    public static final String THIRDUSER_URL = "/api/thirdusers";
    public static final String WEIXIN_authorization_code_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?";
    //告警忽略
    public static final String ALARMSTARATEGIES_IGORE = "/alarmstrategies_ignore/";

    public static final String WAPI_HTTP_SMARTGATE_TOW_URL = WAPI_TOW_URL + SMARTGATE_URL;//二代服务请求地址
    // leancloud
    public static final String LEANCLOUD_BASE = "/avoscloud";
    public static final String INSTALLATION_URL = "/installations";
    public static final String SET_USER_INSTALLATION_URL = WAPI_URL
            + LEANCLOUD_BASE + INSTALLATION_URL;

    /*
     * v3基本请求地址
     */
    public static final String WAPI_URL_S = WAPI_HTTP_URL + "/" + PROJECTNAME
            + "/";

    /*
     * v3登录地址
     */
    public static final String WAPI_USER_LOGIN_URL1 = WAPI_URL_S
            + "loginController.do?apiUserLogin";

    /*
     * v3登录日志地址
     */
    public static final String WAPI_USER_LOGIN_LOG_URL1 = WAPI_URL_S
            + "logController.do?apiLogList";

    /*
     * 请求短信验证码
     */
    public static final String WAPI_USER_SEND_SMSCODE_URL = WAPI_USER_URL
            + SMSCODE_URL;

    /*
     * 注册地址
     */
    public static final String WAPI_USER_SIGNUP_WITH_PHONE_URL = WAPI_HTTP_URL
            + THIRDUSER_URL;

	/*
     * v2修改登录密码 public static final String WAPI_USER_CHANGE_PASSWORD_URL =
	 * WAPI_USER_URL + PASSWORD_URL;
	 */

    /*
     * v3修改当前用户密码
     */
    public static final String WAPI_USER_CHANGE_PASSWORD_URL = WAPI_URL_S
            // + "userController.do?apiUserChangePasswd";
            + "userController.do?apiUserCurrChangePasswd";

    /*
     * v2获取用户帐号信息
     */
    public static final String WAPI_USER_INFO_URL = WAPI_USER_TOW_URL + INFO_URL;

    /*
     * v3获取帐号明细信息
     */
    public static final String WAPI_USER_CONVER_SATION_URL = WAPI_URL_S
            + "userController.do?apiUserGetInfo";
    // + "userController.do?apiUserCurrGetInfo";

    /*
     * v3关于我们
     */
    public static final String WAPI_USER_ABOUT_URL = WAPI_URL_S
            + "yyTopicController.do?apiGetLegalStatement";

    /*
     * v3用户协议
     */
    public static final String WAPI_USER_PROTACOL_URL = WAPI_URL_S
            + "yyTopicController.do?apiGetUserguide";

    /*
     * v3广告列表
     */
    public static final String WAPI_USER_ADVER_URL = WAPI_URL_S
            + "yyTopicController.do?apiGetADList";

    /*
     * v3投诉建议列表
     */
    public static final String WAPI_USER_PROPOSAL_URL = WAPI_URL_S
            + "yyUseradviceController.do?apiUseradviceGetList";
    /*
     * v3投诉建议问题详情
     */
    public static final String WAPI_USER_PROPOSAL_EXA_URL = WAPI_URL_S
            + "yyUseradviceController.do?apiUseradviceGetInfo";
    /*
     * v3新增投诉建议列表
     */
    public static final String WAPI_USER_ADVISORY_URL = WAPI_URL_S
            + "yyUseradviceController.do?apiUseradviceCreateInfo";

    /*
     * v3投诉建议回复
     */
    public static final String WAPI_USER_PROPOSAL_REPLY_URL = WAPI_URL_S
            + "yyUseradviceController.do?apiUseradviceReplyInfo";
    /*
     * v3投诉建议关闭
     */
    public static final String WAPI_USER_ADVISORY_CLOSE_URL = WAPI_URL_S
            + "yyUseradviceController.do?apiUseradviceCloseInfo";

    /*
     * v3登出
     */
    public static final String WAPI_USER_EXIT_URL = WAPI_URL_S
            + "loginController.do?apiUserLogout";

    /*
     * v3商户信息
     */
    public static final String WAPI_MERCHANT_INFO_URL = WAPI_URL_S
            + "yyTenantController.do?apiTenantGetInfo";

    /*
     * v3商户信息修改
     */
    public static final String WAPI_MERCHANT_UPDATE_URL = WAPI_URL_S
            + "yyTenantController.do?apiTenantUpdateInfo";

    /*
     * v3用户列表
     */
    public static final String WAPI_USER_GET_LIST_URL = WAPI_URL_S
            + "userController.do?apiUserGetList";

    /*
     * v3用户明细
     */
    public static final String WAPI_USER_GET_EDIT_URL = WAPI_URL_S
            + "userController.do?apiUserGetInfo";

    /*
     * v3用户修改
     */
    public static final String WAPI_USER_GET_UPDATE_URL = WAPI_URL_S
            + "userController.do?apiUserUpdateInfo";

    /*
     * v3用户新增
     */
    public static final String WAPI_USER_GET_ADD_URL = WAPI_URL_S
            + "userController.do?apiUserCreateInfo";

    /*
     * v3用户注销
     */
    public static final String WAPI_USER_CANCELL_URL = WAPI_URL_S
            + "userController.do?apiUserInactiveInfo";

    /*
     * v3用户激活
     */
    public static final String WAPI_USER_ACTIVAT_URL = WAPI_URL_S
            + "userController.do?apiUserActiveInfo";

    /*
     * v3用户管理-查看大棚列表
     */
    public static final String WAPI_USER_GREEN_HOUSE_LIST_URL = WAPI_URL_S
            + "userController.do?apiUserGetGreenhouseList";

    /*
     * v3角色列表
     */
    public static final String WAPI_ROLE_GET_LIST_URL = WAPI_URL_S
            + "roleController.do?apiRoleGetList";

    /*
     * v3角色编辑明细
     */
    public static final String WAPI_ROLE_GET_EDIT_URL = WAPI_URL_S
            + "roleController.do?apiRoleGetInfo";

    /*
     * v3角色新增
     */
    public static final String WAPI_ROLE_ADD_URL = WAPI_URL_S
            + "roleController.do?apiRoleCreateInfo";

    /*
     * v3角色修改
     */
    public static final String WAPI_ROLE_UPDATE_URL = WAPI_URL_S
            + "roleController.do?apiRoleUpdateInfo";

    /*
     * v3角色删除
     */
    public static final String WAPI_ROLE_DEL_URL = WAPI_URL_S
            + "roleController.do?apiUserDeleteInfo";

    /*
     * v3角色管理-查看用户列表
     */
    public static final String WAPI_ROLE_MANAGER_ORG_USER_URL = WAPI_URL_S
            + "roleController.do?apiRoleGetUserList";

    /*
     * v3机构管理-查看用户列表
     */
    public static final String WAPI_ORGANIZA_MANAGER_USER_URL = WAPI_URL_S
            + "departController.do?apiDepartGetUserList";

    /*
     * v3组织机构列表
     */
    public static final String WAPI_ORGANIZATION_LIST_URL = WAPI_URL_S
            + "departController.do?apiDepartGetList";

    /*
     * v3组织机构编辑明细
     */
    public static final String WAPI_ORGANIZATION_Edit_URL = WAPI_URL_S
            + "departController.do?apiDepartGetInfo";

    /*
     * v3组织机构---修改
     */
    public static final String WAPI_ORGANIZATION_UPDATE_URL = WAPI_URL_S
            + "departController.do?apiDepartUpdateInfo";

    /*
     * v3组织机构---新增
     */
    public static final String WAPI_ORGANIZATION_ADD_URL = WAPI_URL_S
            + "departController.do?apiDepartCreateInfo";

    /*
     * v3组织机构---删除
     */
    public static final String WAPI_ORGA_DEL_URL = WAPI_URL_S
            + "departController.do?apiDepartDeleteInfo";

    /*
     * v3基地列表
     */
    public static final String WAPI_BASE_MANAGER_LIST_URL = WAPI_URL_S
            + "yyGreenbaseController.do?apiGreenbaseGetList";

    /*
     * v3基地新增
     */
    public static final String WAPI_BASE_ADD_URL = WAPI_URL_S
            + "yyGreenbaseController.do?apiGreenbaseCreateInfo";

    /*
     * v3基地编辑
     */
    public static final String WAPI_BASE_UPDATE_URL = WAPI_URL_S
            + "yyGreenbaseController.do?apiGreenbaseUpdateInfo";

    /*
     * v3基地查看
     */
    public static final String WAPI_BASE_EXA_URL = WAPI_URL_S
            + "yyGreenbaseController.do?apiGreenbaseGetInfo";

    /*
     * v3基地排序
     */
    public static final String WAPI_BASE_SORT_URL = WAPI_URL_S
            + "yyGreenbaseController.do?apiGreenbaseSort";

    /*
     * v3基地中大棚排序
     */
    public static final String WAPI_BASE_GHOUSE_SORT_URL = WAPI_URL_S
            + "yyGreenbaseController.do?apiGreenhouseSort";

    /*
     * v3基地删除
     */
    public static final String WAPI_BASE_DELETE_URL = WAPI_URL_S
            + "yyGreenbaseController.do?apiGreenbaseDeleteInfo";

    /*
     * v3基地中大棚列表
     */
    public static final String WAPI_BASE_GREEN_HOUSE_URL = WAPI_URL_S
            + "yyGreenhouseController.do?apiGreenhouseGetListByGB";

    /*
     * v3大棚管理列表
     */
    public static final String WAPI_GHOUSE_MANAGER_LIST_URL = WAPI_URL_S
            + "yyGreenhouseController.do?apiGreenhouseGetList";

    /*
     * v3大棚新增
     */
    public static final String WAPI_GHOUSE_ADD_URL = WAPI_URL_S
            + "yyGreenhouseController.do?apiGreenhouseCreateInfo";

    /*
     * v3大棚编辑
     */
    public static final String WAPI_GHOUSE_EDIT_URL = WAPI_URL_S
            + "yyGreenhouseController.do?apiGreenhouseUpdateInfo";

    /*
     * v3大棚查看
     */
    public static final String WAPI_GHOUSE_EXAVIEW_URL = WAPI_URL_S
            + "yyGreenhouseController.do?apiGreenhouseGetInfo";

    /*
     * v3大棚删除
     */
    public static final String WAPI_GHOUSE_DELETE_URL = WAPI_URL_S
            + "yyGreenhouseController.do?apiGreenhouseDeleteInfo";

    /*
     * v3大棚图片
     */
    public static final String WAPI_GHOUSE_IMAGE_URL = WAPI_URL_S
            + "yyGreenhouseDocController.do?apiGreenhouseDocList";

    /*
     * v3大棚图片新增
     */
    public static final String WAPI_GHOUSE_ADD_IMAGE_URL = WAPI_URL_S
            + "yyGreenhouseDocController.do?apiGreenhouseDocCreateInfo";

    /*
     * v3大棚图片修改
     */
    public static final String WAPI_GHOUSE_EDIT_IMAGE_URL = WAPI_URL_S
            + "yyGreenhouseDocController.do?apiGreenhouseDocUpdateInfo";

    /*
     * v3大棚图片查看
     */
    public static final String WAPI_GHOUSE_IMAGE_EXA_URL = WAPI_URL_S
            + "yyGreenhouseDocController.do?apiGreenhouseDocGetInfo";

    /*
     * v3大棚图片删除
     */
    public static final String WAPI_GHOUSE_IMAGE_DEL_URL = WAPI_URL_S
            + "yyGreenhouseDocController.do?apiGreenhouseDocDeleteInfo";
    /*
     * v3大棚网关列表
     */
    public static final String WAPI_GHOUSE_GATE_LIST_URL = WAPI_URL_S
            + "moSmartgateController.do?apiSmartgateGetList";

    /*
     * v3大棚网关绑定
     */
    public static final String WAPI_GHOUSE_GATE_BIND_URL = WAPI_URL_S
            + "moSmartgateController.do?apiSmartgateBind";
    /*
     * v3大棚网关二代数据
     */
    public static final String WAPI_MIGRA_DATA_LIST_URL = WAPI_URL_S
            + "moSmartgateController.do?apimoSgateCodeGetList";

    /*
     * v3大棚网关解绑
     */
    public static final String WAPI_GHOUSE_GATE_UNBIND_URL = WAPI_URL_S
            + "moSmartgateController.do?apiSmartgateUnBind";
    /*
     * v3大棚网关详情
     */
    public static final String WAPI_GATE_DETAILS_URL = WAPI_URL_S
            + "moSmartgateController.do?apimoSmartgateGetInfo";

    /*
     * v3大棚用户列表 大棚员工
     */
    public static final String WAPI_GHOUSE_USER_LIST_URL = WAPI_URL_S
            + "yyGreenhouseUserController.do?apiGreenhouseUserList";

    /*
     * v3大棚用户明细
     */
    public static final String WAPI_GHOUSE_USER_EXA_URL = WAPI_URL_S
            + "yyGreenhouseUserController.do?apiGreenhouseUserGetInfo";

    /*
     * v3大棚员工绑定
     */
    public static final String WAPI_GHOUSE_USER_BIND_URL = WAPI_URL_S
            + "yyGreenhouseUserController.do?apiGreenhouseUserBindInfo";

    /*
     * v3农事种植计划列表
     */
    public static final String WAPI_PLAN_SCHEME_LIST_URL = WAPI_URL_S
            + "yyPlantingplanController.do?apiPlantingPlanGetUserList";
    /*
     * v3农事种植计划新增
     */
    public static final String WAPI_PLAN_SCHEME_CREATEINFO_URL = WAPI_URL_S
            + "yyPlantingplanController.do?apiPlantingPlanCreateInfo";
    /*
     * v3农事种植计划修改
     */
    public static final String WAPI_PLAN_SCHEME_UPDATEINFO_URL = WAPI_URL_S
            + "yyPlantingplanController.do?apiPlantingPlanUpdateInfo";
    /*
     * v3农事种植计划复制
     */
    public static final String WAPI_PLAN_SCHEME_COPYINFO_URL = WAPI_URL_S
            + "yyPlantingplanController.do?apiPlantingPlanCopyInfo";
    /*
     * v3农事种植计划明细
     */
    public static final String WAPI_PLAN_SCHEME_GETINFO_URL = WAPI_URL_S
            + "yyPlantingplanController.do?apiPlantingPlanGetInfo";
    /*
     * v3系统公告列表
     */
    public static final String WAPI_NOTICE_CONTEOLLER_LIST_URL = WAPI_URL_S
            + "noticeController.do?apiNoticeControllerList";
    /*
     * v3系统公告已读设置
     */
    public static final String WAPI_NOTICE_CONTEOLLER_SET_URL = WAPI_URL_S
            + "noticeController.do?apiNoticeControllerSet";
    /*
     * v3系统公告列表明细
     */
    public static final String WAPI_NOTICE_CONTEOLLER_GETINFO_URL = WAPI_URL_S
            + "noticeController.do?apiNoticeControllerGetInfo";
    /*
     * v3农事记录列表
     */
    public static final String WAPI_FRAMING_RECORD_GETLIST_URL = WAPI_URL_S
            + "yyFramingRecordController.do?apiFramingRecordGetList";
    /*
     * v3农事记录查看
     */
    public static final String WAPI_FRAMING_RECORD_GETINFO_URL = WAPI_URL_S
            + "yyFramingRecordController.do?apiFramingRecordGetInfo";
    /*
     * v3农事记录新增
     */
    public static final String WAPI_FRAMING_RECORD_CREATEINFO_URL = WAPI_URL_S
            + "yyFramingRecordController.do?apiFramingRecordCreateInfo";

    /*
     * v3农事任务列表
     */
    public static final String WAPI_FAR_TASK_LIST_URL = WAPI_URL_S
            + "yyPlantingTaskController.do?apiPlantingTaskGetList";

    /*
     * v3农事任务新增
     */
    public static final String WAPI_FAR_TASK_ADD_URL = WAPI_URL_S
            + "yyPlantingTaskController.do?apiPlantingTaskCreateInfo";

    /*
     * v3农事任务明细
     */
    public static final String WAPI_FAR_TASK_DETAIL_URL = WAPI_URL_S
            + "yyPlantingTaskController.do?apiPlantingTaskGetInfo";

    /*
     * v3农事任务编辑
     */
    public static final String WAPI_FAR_TASK_EDIT_URL = WAPI_URL_S
            + "yyPlantingTaskController.do?apiPlantingTaskUpdateInfo";

    /*
     * v3农事任务分配
     */
    public static final String WAPI_FAR_TASK_DISTR_URL = WAPI_URL_S
            + "yyPlantingTaskController.do?apiPlantingTaskAllot";

    /*
     * v3农事任务取消
     */
    public static final String WAPI_FAR_TASK_CANCEL_URL = WAPI_URL_S
            + "yyPlantingTaskController.do?apiPlantingTaskCancelInfo";

    /*
     * v3农事任务关闭
     */
    public static final String WAPI_FAR_TASK_CLOSE_URL = WAPI_URL_S
            + "yyPlantingTaskController.do?apiPlantingTaskCloseInfo";

    /*
     * v3我的每日农事任务关闭
     */
    public static final String WAPI_MY_FAR_TASK_CLOSE_URL = WAPI_URL_S
            + "yyWorktaskDayController.do?apiWorkTaskDayCloseInfo";

    /*
     * v3农事任务复制
     */
    public static final String WAPI_FAR_TASK_COPY_URL = WAPI_URL_S
            + "yyPlantingTaskController.do?apiPlantingTaskCopyInfo";

    /*
     * v3执行任务列表
     */
    public static final String WAPI_TASK_EXECUTE_URL = WAPI_URL_S
            + "yyWorktaskController.do?apiWorktaskGetList";

    /*
     * v3执行任务明细
     */
    public static final String WAPI_TASK_EXECUTE_DETAIL_URL = WAPI_URL_S
            + "yyWorktaskController.do?apiWorktaskGetInfo";

    /*
     * v3执行任务取消
     */
    public static final String WAPI_TASK_EXECUTE_CANCEL_URL = WAPI_URL_S
            + "yyWorktaskController.do?apiWorkTaskCancelInfo";

    /*
     * v3取消每日农事任务取消
     */
    public static final String WAPI_MY_FAR_TASK_CANCEL_URL = WAPI_URL_S
            + "yyWorktaskDayController.do?apiWorkTaskDayCancelInfo";

    /*
     * v3执行任务关闭
     */
    public static final String WAPI_TASK_EXECUTE_CLOSE_URL = WAPI_URL_S
            + "yyWorktaskController.do?apiWorkTaskCloseInfo";

    /*
     * v3当日任务列表(我的农事记录)
     */
    public static final String WAPI_TODAY_TASK_LIST_URL = WAPI_URL_S
            + "yyWorktaskDayController.do?apiWorktaskDayGetList";

    /*
     * v3当日任务明细
     */
    public static final String WAPI_TODAY_TASK_DETAIL_URL = WAPI_URL_S
            + "yyWorktaskDayController.do?apiWorktaskDayGetInfo";

    /*
     * v3当日任务领用
     */
    public static final String WAPI_TODAY_TASK_COLLECT_URL = WAPI_URL_S
            + "yyWorktaskDayController.do?apiWorkTaskDayExecutionInfo";

    /*
     * v3数据字典
     */
    public static final String WAPI_DATA_DICTINOARY_URL = WAPI_URL_S
            + "yyFramingRecordController.do?apiTypeGetList";

    /*
     * v3监控大棚网关列表
     */
    public static final String WAPI_GHOUSE_GATE_MOSMART_LIST_URL = WAPI_URL_S
            + "yyGreenhouseMonitorController.do?apiMoSmartgateListByTenantID";

    /*
     * v3监控大棚环境平均值
     */
    public static final String WAPI_GHOUSE_AVERAGE_URL = WAPI_URL_S
            + "yyGreenhouseMonitorController.do?apiAverageDataByGHouseID";

    /*
     * v3监控大棚环境平均值折线图
     */
    public static final String WAPI_GHOUSE_LINE_CHART_URL = WAPI_URL_S
            + "yyGreenhouseMonitorController.do?apiAverageChartBySgateCode";

    /*
     * v3传感器折线图
     */
    public static final String WAPI_GHOUSE_Env_AVERAGE_SENSOR_URL = WAPI_URL_S
            + "yyGreenhouseMonitorController.do?apiMonitorChartByDevSN";

    /*
     * v3大棚网关传感器列表监控
     */
    public static final String WAPI_GHOUSE_DATA_MOSMART_SENSOR_LIST_URL = WAPI_URL_S
            + "yyGreenhouseMonitorController.do?apiMonitorDataByGHouseID";

    /*
     * v3大棚网关继电器列表监控
     */
    public static final String WAPI_GHOUSE_DATA_MOSMART_RELAY_LIST_URL = WAPI_URL_S
            + "yyGreenhouseMonitorController.do?apiMonitorDataByGHouseID";

    /*
     * v3大棚设备列表
     */
    public static final String WAPI_GHOUSE_DATA_ALL_RELAY_LIST_URL = WAPI_URL_S
            + "yyGreenhouseMonitorController.do?apiDeviceByGHouseIDRE";

    /*----------------------------------------------------- End------------------------------------------------------------*/

    /*
     * 更新用户昵称
     */
    public static final String WAPI_USER_NICKNAME_URL = WAPI_USER_URL
            + NICKNAME_URL;

    public static final String WAPI_USER_SMARTGATE_URL = WAPI_USER_URL
            + SMARTGATE_URL;
    public static final String WAPI_SMARTGATE_URL = WAPI_TOW_URL + SMARTGATE_URL;

    public static final String WAPI_USER_CONTACT_URL = WAPI_USER_TOW_URL
            + CONTACT_URL;
    public static final String WAPI_ENDDEVICE_URL = WAPI_TOW_URL + ENDDEVICE_URL;

    /*
     * 告警忽略地址
	 */
    public static final String WAPI_USER_ALARMSTARATEGIES_IGORE = WAPI_USER_TOW_URL + ALARMSTARATEGIES_IGORE;
    /*
     * 用户添加需要查看的设备
	 */
    // public static final String WAPI_USER_ADD_DEVICE_URL = WAPI_HTTP_URL
    // + "/api/users/add_device";

	/*
     * 用户删除需要查看的设备
	 */
    // public static final String WAPI_USER_RM_DEVICE_URL = WAPI_HTTP_URL
    // + "/api/users/rm_device";

	/*
     * 用户添加报警手机
	 */
    // public static final String WAPI_USER_ADD_CONTACT = WAPI_HTTP_URL
    // + "/api/users/add_contact";

	/*
     * 用户删除报警手机
	 */
    // public static final String WAPI_USER_RM_CONTACT = WAPI_HTTP_URL
    // + "/api/users/rm_contact";

	/*
     * 获取设备列表
	 */
    // public static final String WAPI_DEVICE_LIST_URL = WAPI_HTTP_URL
    // + "/api/devices/list";

	/*
     * 获取指定设备信息
	 */
    // public static final String WAPI_DEVICE_INFO_URL = WAPI_HTTP_URL
    // + "/api/devices/info";

	/*
     * 更新设备的别名
	 */
    // public static final String WAPI_DEVICE_DEV_ALIAS_URL = WAPI_HTTP_URL
    // + "/api/devices/dev_alias";

    /*
     * 更新设备的组件(传感器等)的别名
     */
    public static final String WAPI_DEVICE_DEV_COMPONENT_ALIAS_URL = WAPI_HTTP_URL
            + "/api/devices/dev_component_alias";

    /*
     * 远程控制继电机的开关状态
     */
    public static final String WAPI_REMOTE_DO_CMD_URL = WAPI_HTTP_URL
            + "/api/remotes/erelays/actions";

    public static final String WAPI_REMOTE_DO2_CMD_URL = WAPI_HTTP_TOW_BASE + ":80"//测试
            + "/api/remotes/erelays/actions";

    /*
     * 获取设备中组件的自动化时间表
     */
    public static final String WAPI_DEVICE_COMPONENT_SCHEDULE_URL = WAPI_HTTP_URL
            + "/api/devices/component_schedule";

    /*
     * 获取指定设备的图片信息
     */
    public static final String WAPI_PICTURE_LIST_URL = WAPI_HTTP_URL
            + "/api/picture/list";

    /*
     * 上传用户返馈信息
     */
    public static final String WAPI_ADVICE_URL = WAPI_HTTP_URL + "/api/advice";

	/*
     * 获取大棚设备报警列表
	 */
    // public static final String WAPI_ALARM_LIST_URL = WAPI_HTTP_URL
    // + "/api/alarm/list";

    /*
     * 用户删除需要查看的设备
     */
    public static final String WAPI_DEVGEOGROUP_INFO_URL = WAPI_HTTP_URL
            + "/api/devgeogroup/info";

    /*
     * 获取指定省市和农作物的总体地位位置经纬度坐标信息(InfomationPage)
     */
    public static final String WAPI_DEVGEOGROUP_LOCATION_FINFO_URL = WAPI_HTTP_URL
            + "/api/devgeogroup/location_info";

    /*
     * 获取指定设备的统计分析信息
     */
    public static final String WAPI_ANALYSIS_RESULT_RUL = WAPI_HTTP_URL
            + "/api/analyses/histories";

    /**
     * 用户第三方登录(LoginThird)
     */
    public static final String WAPI_LOGIN_THIRD_URL = WAPI_HTTP_URL
            + "/api/thirdsessions";

    /**
     * 用户第三方注册(RegisterThird)
     */
    public static final String WAPI_REGISTER_THIRD_URL = WAPI_HTTP_URL
            + "/api/thirdusers";

    public static final String WAPI_DEVS_URL = WAPI_HTTP_URL + "/devs/";

    public static final String WAPI_DELETE_SHED = WAPI_HTTP_URL
            + "/api/users/smartgates/";

    /**
     * 用户通过手机注册(RegisterPhone)
     */
    public static final String WAPI_REGISTER_PHONE_URL = WAPI_USER_URL
            + "/phones";
    public final static int MSG_ONLOADSHEDINFO = 1000;
    public final static int MSG_REFRESH = 2000;
    public final static int MSG_INIT_TEMPERATURE_CHART = 3000;
    public final static int MSG_ERELAY2_CTRL = 4000;
    public final static int MSG_ERELAY2_VENTILATIONCTRL = 4001;
    public final static int MSG_ERELAY_BOX = 4008;
    public final static int MSG_ERELAY_CTRL = 5000;
    private static long time;
    private static long time2;

    public static String http_get_content(String url) {
        HttpGet request = new HttpGet(url);
        request.setHeader("User-Agent", TAMyProfile.http_user_agent);

        HttpClient httpClient = new DefaultHttpClient();
        try {
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String str = EntityUtils.toString(response.getEntity(),
                        HTTP.UTF_8);
                return str;
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return "";
    }

    public static String http_get_content(String url, String session_token) {
        time = System.currentTimeMillis();
        String currentTimeOne = DateLocalUtil.getMillon(time);
        Log.v("menhu", "请求前：" + currentTimeOne);
        HttpGet request = new HttpGet(url);
        request.setHeader("User-Agent", TAMyProfile.http_user_agent);
        request.setHeader("Authorization", "bearer " + session_token);
        System.out.println(url);
        HttpClient httpClient = new DefaultHttpClient();
        try {
            HttpResponse response = httpClient.execute(request);
            time2 = System.currentTimeMillis();
            String currentTimeTwo = DateLocalUtil.getMillon(time2);
            Log.v("menhu", "请求后： " + currentTimeTwo);
            System.out.println(response.getStatusLine().getStatusCode());
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String str = EntityUtils.toString(response.getEntity(),
                        HTTP.UTF_8);
                return str;
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String http_post_content(String url,
                                           List<NameValuePair> params) {
        String result = "";
        System.out.println(url);
        // 第一步，创建HttpPost对象
        HttpPost httpPost = new HttpPost(url);
        HttpResponse httpResponse = null;
        try {
            // 设置httpPost请求参数
            httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            httpResponse = new DefaultHttpClient().execute(httpPost);
            System.out.println(httpResponse.getStatusLine().getStatusCode());
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                // 第三步，使用getEntity方法获得返回结果
                result = EntityUtils.toString(httpResponse.getEntity());
                System.out.println("result:" + result);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String http_post_content(String url,
                                           List<NameValuePair> params, String session_token) {
        String result = "";
        int statusCode = 0;
        System.out.println(url);
        // 第一步，创建HttpPost对象
        HttpPost httpPost = new HttpPost(url);
        HttpResponse httpResponse = null;
        try {
            // 设置httpPost请求参数
            httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            httpPost.setHeader("Authorization", "bearer " + session_token);
            httpResponse = new DefaultHttpClient().execute(httpPost);
            statusCode = httpResponse.getStatusLine().getStatusCode();
            result = EntityUtils.toString(httpResponse.getEntity());

			/*
             * if (httpResponse.getStatusLine().getStatusCode() == 200) { //
			 * 第三步，使用getEntity方法获得返回结果 result =
			 * EntityUtils.toString(httpResponse.getEntity()); } else if
			 * (httpResponse.getStatusLine().getStatusCode() == 401) { result =
			 * EntityUtils.toString(httpResponse.getEntity()); }
			 */
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String http_put_content(String url, List<NameValuePair> params) {
        String result = "";
        System.out.println(url);
        // 第一步，创建HttpPost对象
        HttpPut httpPut = new HttpPut(url);
        HttpResponse httpResponse = null;
        try {
            // 设置httpPost请求参数
            httpPut.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            httpResponse = new DefaultHttpClient().execute(httpPut);
            System.out.println(httpResponse.getStatusLine().getStatusCode());
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                // 第三步，使用getEntity方法获得返回结果
                result = EntityUtils.toString(httpResponse.getEntity());
                System.out.println("result:" + result);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String http_put_content(String url,
                                          List<NameValuePair> params, String session_token) {
        String result = "";
        System.out.println(url);
        // 第一步，创建HttpPost对象
        HttpPut httpPut = new HttpPut(url);
        HttpResponse httpResponse = null;
        try {
            // 设置httpPost请求参数
            httpPut.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            httpPut.setHeader("Authorization", "bearer " + session_token);
            httpResponse = new DefaultHttpClient().execute(httpPut);
            System.out.println(httpResponse.getStatusLine().getStatusCode());
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                // 第三步，使用getEntity方法获得返回结果
                result = EntityUtils.toString(httpResponse.getEntity());
                System.out.println("result:" + result);
            } else if (httpResponse.getStatusLine().getStatusCode() == 401) {
                result = EntityUtils.toString(httpResponse.getEntity());
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String get_content_from_remote_url(String url,
                                                     String session_token) {
        try {
            String scontent = http_get_content(url, session_token);
            if (scontent == null || scontent == "")
                return null;
            return scontent;
        } catch (Exception e) {

        }

        return null;
    }

    public static String get_content_from_remote_url(String url) {
        try {
            String scontent = http_get_content(url);
            if (scontent == null || scontent == "")
                return null;
            return scontent;
        } catch (Exception e) {

        }

        return null;
    }

    public static String http_delete_content(String url) {
        HttpDelete request = new HttpDelete(url);
        request.setHeader("User-Agent", TAMyProfile.http_user_agent);

        HttpClient httpClient = new DefaultHttpClient();
        try {
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String str = EntityUtils.toString(response.getEntity(),
                        HTTP.UTF_8);
                return str;
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String http_delete_content(String url, String session_token) {
        HttpDelete request = new HttpDelete(url);
        request.setHeader("User-Agent", TAMyProfile.http_user_agent);
        request.setHeader("Authorization", "bearer " + session_token);
        System.out.println(url);
        HttpClient httpClient = new DefaultHttpClient();
        try {
            HttpResponse response = httpClient.execute(request);
            System.out.println(response.getStatusLine().getStatusCode());
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String str = EntityUtils.toString(response.getEntity(),
                        HTTP.UTF_8);
                return str;
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static int save_to_private_file(Context context, String scontent,
                                           String filename) {
        int ret = 1;
        try {
            FileOutputStream fos = context.openFileOutput(filename,
                    Context.MODE_PRIVATE);
            fos.write(scontent.getBytes());
            fos.close();
            ret = 0;
        } catch (Exception e) {
        }

        return ret;
    }
}
