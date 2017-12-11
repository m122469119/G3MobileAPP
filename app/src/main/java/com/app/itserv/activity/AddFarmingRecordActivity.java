package com.app.itserv.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.app.itserv.BaseActivity;
import com.itserv.app.util.DateDialog;
import com.itserv.app.util.DateUtils;
import com.itserv.app.util.LogUtils;
import com.itserv.app.util.TimeDialog;
import com.itserv.shed.R;
import com.yycloud.app.utils.DateLocalUtil;

import butterknife.BindView;

/**
 * 作者： 周作威 on 2017/10/9 15:30.
 * 类描述：
 */
public class AddFarmingRecordActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.tv_addfarm_startdate)
    TextView tvAddfarmStartdate;
    @BindView(R.id.tv_addfarm_enddate)
    TextView tvAddfarmEnddate;
    @BindView(R.id.far_exa_greenhouse)
    TextView farExaGreenhouse;
    @BindView(R.id.far_exa_classify)
    TextView farExaClassify;
    @BindView(R.id.btn_auto_build)
    Button btnAutoBuild;
    @BindView(R.id.btn_manual_edit)
    Button btnManualEdit;
    @BindView(R.id.far_exa_task_describe)
    EditText farExaTaskDescribe;
    @BindView(R.id.far_exa_ck_issue)
    CheckBox farExaCkIssue;
    @BindView(R.id.far_exa_issue_explain)
    EditText farExaIssueExplain;
    @BindView(R.id.ll_far_ex_problem_description)
    LinearLayout llFarExProblemDescription;
    @BindView(R.id.far_exa_upload_issue_img)
    TextView farExaUploadIssueImg;
    @BindView(R.id.ll_far_ex_upload_pictures)
    LinearLayout llFarExUploadPictures;
    @BindView(R.id.far_exa_preview3)
    ImageView farExaPreview3;
    @BindView(R.id.ll_far_ex_preview)
    LinearLayout llFarExPreview;
    @BindView(R.id.far_exa_btn_submite)
    Button farExaBtnSubmite;
    @BindView(R.id.far_exa_cannel)
    Button farExaCannel;
    @BindView(R.id.far_exa_ll_supply)
    LinearLayout farExaLlSupply;
    public long startTime = System.currentTimeMillis();
    public long endTime = System.currentTimeMillis();

    @Override
    protected int layoutViewId() {
        return R.layout.addfarmingrecord_activity;
    }

    @Override
    protected void init() {
        super.init();
        imgBack.setOnClickListener(this);
        tvAddfarmStartdate.setOnClickListener(this);
        tvAddfarmEnddate.setOnClickListener(this);
        tvAddfarmStartdate.setText(DateUtils.getFromat("yyyy-MM-dd HH:mm", startTime));
        tvAddfarmEnddate.setText(DateUtils.getFromat("yyyy-MM-dd HH:mm", endTime));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.tv_addfarm_startdate:
                DateDialog startDialog = new DateDialog(this, startTime, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, final int year, final int monthOfYear, final int dayOfMonth) {
                        TimeDialog timeDialog = new TimeDialog(AddFarmingRecordActivity.this, startTime, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                int m = monthOfYear + 1;
                                try {
                                    startTime = DateUtils.getStringTime("yyyy-MM-dd HH:mm", (year + "-" + m + "-" + dayOfMonth + " " + hourOfDay + ":" + minute));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                tvAddfarmStartdate.setText(DateUtils.getFromat("yyyy-MM-dd HH:mm", startTime));
                            }
                        });
                        timeDialog.show();
                    }
                });
                startDialog.show();
                break;
            case R.id.tv_addfarm_enddate:
                DateDialog endDialog = new DateDialog(this, endTime, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, final int year, final int monthOfYear, final int dayOfMonth) {
                        TimeDialog timeDialog = new TimeDialog(AddFarmingRecordActivity.this, endTime, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                int m = monthOfYear + 1;
                                try {
                                    endTime = DateUtils.getStringTime("yyyy-MM-dd HH:mm", (year + "-" + m + "-" + dayOfMonth + " " + hourOfDay + ":" + minute));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                tvAddfarmEnddate.setText(DateUtils.getFromat("yyyy-MM-dd HH:mm", endTime));
                            }
                        });
                        timeDialog.show();
                    }
                });
                endDialog.show();
                break;
        }
    }
}
