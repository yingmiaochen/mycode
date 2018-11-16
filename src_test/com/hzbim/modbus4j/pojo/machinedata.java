package com.hzbim.modbus4j.pojo;

import java.util.Date;

public class machinedata {
	
	private long machdata_id;//machdata_id
	private String machdata_machcode;//机组编码
	private int machdata_status;//机组状态,0=关机，1=开机
	private float machdata_airtemp;//外部环境温度
	private float machdata_watertemp;//自然冷却进水温度
	private int machdata_pump2status;//第二水泵状态，0：关—1：开
	private float machdata_summertemp;//夏季温度
	private float machdata_wintertemp;//冬季温度
	private float machdata_zfqjstemp;//蒸发器进水温度
	private float machdata_zfqcstemp;//蒸发器出水温度
	private int machdata_zfqpump1status;//蒸发器水泵1状态，0：关—1：开
	private int machdata_zfqpump2status;//蒸发器水泵2状态，0：关—1：开
	private float machdata_zfqwatertempset;//蒸发器水温度带设定
	private float machdata_lnqjstemp;//冷凝器进水温度
	private float machdata_lnqcstemp;//冷凝器出水温度
	private int machdata_lnqpumpstatus;//冷凝器水泵状态，0：关—1：开
	private float machdata_rhsjstemp;//热回收进水温度
	private float machdata_rhscstemp;//热回收出水温度
	private int machdata_rhspumpstatus;//热回收水泵状态，0：关—1：开
	private float machdata_rhstempset;//热回收水温度设定
	private float machdata_rhstempturn;//热回收水温度调节比率
	private float machdata_lowpressure1;//低压压力1
	private float machdata_lowpressure2;//低压压力2
	private float machdata_lowpressure3;//低压压力3
	private float machdata_lowpressure4;//低压压力4
	private float machdata_highpressure1;//高压压力1
	private float machdata_highpressure2;//高压压力2
	private float machdata_highpressure3;//高压压力3
	private float machdata_highpressure4;//高压压力4
	private float machdata_compressor1speed;//压缩机1转速
	private float machdata_compressor2speed;//压缩机2转速
	private float machdata_compressor3speed;//压缩机3转速
	private float machdata_compressor4speed;//压缩机4转速
	private float machdata_compressor5speed;//压缩机5转速
	private float machdata_compressor6speed;//压缩机6转速
	private float machdata_compressor7speed;//压缩机7转速
	private float machdata_compressor8speed;//压缩机8转速
	private float machdata_compressoravg1;//压缩机平均时数1
	private float machdata_compressoravg2;//压缩机平均时数2
	private Date machdata_createtime;//创建时间
	private Date machdata_updatetime;//修改时间
	private String machdata_updateman;//修改人员
	private Date machdata_readtime;//读数时间
	private int machdata_readtype;//读数类型，0-定时，1=抄表,2=设置
	
	
	public long getMachdata_id() {
		return machdata_id;
	}
	public void setMachdata_id(long machdata_id) {
		this.machdata_id = machdata_id;
	}
	public String getMachdata_machcode() {
		return machdata_machcode;
	}
	public void setMachdata_machcode(String machdata_machcode) {
		this.machdata_machcode = machdata_machcode;
	}
	public int getMachdata_status() {
		return machdata_status;
	}
	public void setMachdata_status(int machdata_status) {
		this.machdata_status = machdata_status;
	}
	public float getMachdata_airtemp() {
		return machdata_airtemp;
	}
	public void setMachdata_airtemp(float machdata_airtemp) {
		this.machdata_airtemp = machdata_airtemp;
	}
	public float getMachdata_watertemp() {
		return machdata_watertemp;
	}
	public void setMachdata_watertemp(float machdata_watertemp) {
		this.machdata_watertemp = machdata_watertemp;
	}
	public int getMachdata_pump2status() {
		return machdata_pump2status;
	}
	public void setMachdata_pump2status(int machdata_pump2status) {
		this.machdata_pump2status = machdata_pump2status;
	}
	public float getMachdata_summertemp() {
		return machdata_summertemp;
	}
	public void setMachdata_summertemp(float machdata_summertemp) {
		this.machdata_summertemp = machdata_summertemp;
	}
	public float getMachdata_wintertemp() {
		return machdata_wintertemp;
	}
	public void setMachdata_wintertemp(float machdata_wintertemp) {
		this.machdata_wintertemp = machdata_wintertemp;
	}
	public float getMachdata_zfqjstemp() {
		return machdata_zfqjstemp;
	}
	public void setMachdata_zfqjstemp(float machdata_zfqjstemp) {
		this.machdata_zfqjstemp = machdata_zfqjstemp;
	}
	public float getMachdata_zfqcstemp() {
		return machdata_zfqcstemp;
	}
	public void setMachdata_zfqcstemp(float machdata_zfqcstemp) {
		this.machdata_zfqcstemp = machdata_zfqcstemp;
	}
	public int getMachdata_zfqpump1status() {
		return machdata_zfqpump1status;
	}
	public void setMachdata_zfqpump1status(int machdata_zfqpump1status) {
		this.machdata_zfqpump1status = machdata_zfqpump1status;
	}
	public int getMachdata_zfqpump2status() {
		return machdata_zfqpump2status;
	}
	public void setMachdata_zfqpump2status(int machdata_zfqpump2status) {
		this.machdata_zfqpump2status = machdata_zfqpump2status;
	}
	public float getMachdata_zfqwatertempset() {
		return machdata_zfqwatertempset;
	}
	public void setMachdata_zfqwatertempset(float machdata_zfqwatertempset) {
		this.machdata_zfqwatertempset = machdata_zfqwatertempset;
	}
	public float getMachdata_lnqjstemp() {
		return machdata_lnqjstemp;
	}
	public void setMachdata_lnqjstemp(float machdata_lnqjstemp) {
		this.machdata_lnqjstemp = machdata_lnqjstemp;
	}
	public float getMachdata_lnqcstemp() {
		return machdata_lnqcstemp;
	}
	public void setMachdata_lnqcstemp(float machdata_lnqcstemp) {
		this.machdata_lnqcstemp = machdata_lnqcstemp;
	}
	public int getMachdata_lnqpumpstatus() {
		return machdata_lnqpumpstatus;
	}
	public void setMachdata_lnqpumpstatus(int machdata_lnqpumpstatus) {
		this.machdata_lnqpumpstatus = machdata_lnqpumpstatus;
	}
	public float getMachdata_rhsjstemp() {
		return machdata_rhsjstemp;
	}
	public void setMachdata_rhsjstemp(float machdata_rhsjstemp) {
		this.machdata_rhsjstemp = machdata_rhsjstemp;
	}
	public float getMachdata_rhscstemp() {
		return machdata_rhscstemp;
	}
	public void setMachdata_rhscstemp(float machdata_rhscstemp) {
		this.machdata_rhscstemp = machdata_rhscstemp;
	}
	public int getMachdata_rhspumpstatus() {
		return machdata_rhspumpstatus;
	}
	public void setMachdata_rhspumpstatus(int machdata_rhspumpstatus) {
		this.machdata_rhspumpstatus = machdata_rhspumpstatus;
	}
	public float getMachdata_rhstempset() {
		return machdata_rhstempset;
	}
	public void setMachdata_rhstempset(float machdata_rhstempset) {
		this.machdata_rhstempset = machdata_rhstempset;
	}
	public float getMachdata_rhstempturn() {
		return machdata_rhstempturn;
	}
	public void setMachdata_rhstempturn(float machdata_rhstempturn) {
		this.machdata_rhstempturn = machdata_rhstempturn;
	}
	public float getMachdata_lowpressure1() {
		return machdata_lowpressure1;
	}
	public void setMachdata_lowpressure1(float machdata_lowpressure1) {
		this.machdata_lowpressure1 = machdata_lowpressure1;
	}
	public float getMachdata_lowpressure2() {
		return machdata_lowpressure2;
	}
	public void setMachdata_lowpressure2(float machdata_lowpressure2) {
		this.machdata_lowpressure2 = machdata_lowpressure2;
	}
	public float getMachdata_lowpressure3() {
		return machdata_lowpressure3;
	}
	public void setMachdata_lowpressure3(float machdata_lowpressure3) {
		this.machdata_lowpressure3 = machdata_lowpressure3;
	}
	public float getMachdata_lowpressure4() {
		return machdata_lowpressure4;
	}
	public void setMachdata_lowpressure4(float machdata_lowpressure4) {
		this.machdata_lowpressure4 = machdata_lowpressure4;
	}
	public float getMachdata_highpressure1() {
		return machdata_highpressure1;
	}
	public void setMachdata_highpressure1(float machdata_highpressure1) {
		this.machdata_highpressure1 = machdata_highpressure1;
	}
	public float getMachdata_highpressure2() {
		return machdata_highpressure2;
	}
	public void setMachdata_highpressure2(float machdata_highpressure2) {
		this.machdata_highpressure2 = machdata_highpressure2;
	}
	public float getMachdata_highpressure3() {
		return machdata_highpressure3;
	}
	public void setMachdata_highpressure3(float machdata_highpressure3) {
		this.machdata_highpressure3 = machdata_highpressure3;
	}
	public float getMachdata_highpressure4() {
		return machdata_highpressure4;
	}
	public void setMachdata_highpressure4(float machdata_highpressure4) {
		this.machdata_highpressure4 = machdata_highpressure4;
	}
	public float getMachdata_compressor1speed() {
		return machdata_compressor1speed;
	}
	public void setMachdata_compressor1speed(float machdata_compressor1speed) {
		this.machdata_compressor1speed = machdata_compressor1speed;
	}
	public float getMachdata_compressor2speed() {
		return machdata_compressor2speed;
	}
	public void setMachdata_compressor2speed(float machdata_compressor2speed) {
		this.machdata_compressor2speed = machdata_compressor2speed;
	}
	public float getMachdata_compressor3speed() {
		return machdata_compressor3speed;
	}
	public void setMachdata_compressor3speed(float machdata_compressor3speed) {
		this.machdata_compressor3speed = machdata_compressor3speed;
	}
	public float getMachdata_compressor4speed() {
		return machdata_compressor4speed;
	}
	public void setMachdata_compressor4speed(float machdata_compressor4speed) {
		this.machdata_compressor4speed = machdata_compressor4speed;
	}
	public float getMachdata_compressor5speed() {
		return machdata_compressor5speed;
	}
	public void setMachdata_compressor5speed(float machdata_compressor5speed) {
		this.machdata_compressor5speed = machdata_compressor5speed;
	}
	public float getMachdata_compressor6speed() {
		return machdata_compressor6speed;
	}
	public void setMachdata_compressor6speed(float machdata_compressor6speed) {
		this.machdata_compressor6speed = machdata_compressor6speed;
	}
	public float getMachdata_compressor7speed() {
		return machdata_compressor7speed;
	}
	public void setMachdata_compressor7speed(float machdata_compressor7speed) {
		this.machdata_compressor7speed = machdata_compressor7speed;
	}
	public float getMachdata_compressor8speed() {
		return machdata_compressor8speed;
	}
	public void setMachdata_compressor8speed(float machdata_compressor8speed) {
		this.machdata_compressor8speed = machdata_compressor8speed;
	}
	public float getMachdata_compressoravg1() {
		return machdata_compressoravg1;
	}
	public void setMachdata_compressoravg1(float machdata_compressoravg1) {
		this.machdata_compressoravg1 = machdata_compressoravg1;
	}
	public float getMachdata_compressoravg2() {
		return machdata_compressoravg2;
	}
	public void setMachdata_compressoravg2(float machdata_compressoravg2) {
		this.machdata_compressoravg2 = machdata_compressoravg2;
	}
	public Date getMachdata_createtime() {
		return machdata_createtime;
	}
	public void setMachdata_createtime(Date machdata_createtime) {
		this.machdata_createtime = machdata_createtime;
	}
	public Date getMachdata_updatetime() {
		return machdata_updatetime;
	}
	public void setMachdata_updatetime(Date machdata_updatetime) {
		this.machdata_updatetime = machdata_updatetime;
	}
	public String getMachdata_updateman() {
		return machdata_updateman;
	}
	public void setMachdata_updateman(String machdata_updateman) {
		this.machdata_updateman = machdata_updateman;
	}
	public Date getMachdata_readtime() {
		return machdata_readtime;
	}
	public void setMachdata_readtime(Date machdata_readtime) {
		this.machdata_readtime = machdata_readtime;
	}
	public int getMachdata_readtype() {
		return machdata_readtype;
	}
	public void setMachdata_readtype(int machdata_readtype) {
		this.machdata_readtype = machdata_readtype;
	}
	@Override
	public String toString() {
		return "machinedata [machdata_id=" + machdata_id + ", machdata_machcode=" + machdata_machcode
				+ ", machdata_status=" + machdata_status + ", machdata_airtemp=" + machdata_airtemp
				+ ", machdata_watertemp=" + machdata_watertemp + ", machdata_pump2status=" + machdata_pump2status
				+ ", machdata_summertemp=" + machdata_summertemp + ", machdata_wintertemp=" + machdata_wintertemp
				+ ", machdata_zfqjstemp=" + machdata_zfqjstemp + ", machdata_zfqcstemp=" + machdata_zfqcstemp
				+ ", machdata_zfqpump1status=" + machdata_zfqpump1status + ", machdata_zfqpump2status="
				+ machdata_zfqpump2status + ", machdata_zfqwatertempset=" + machdata_zfqwatertempset
				+ ", machdata_lnqjstemp=" + machdata_lnqjstemp + ", machdata_lnqcstemp=" + machdata_lnqcstemp
				+ ", machdata_lnqpumpstatus=" + machdata_lnqpumpstatus + ", machdata_rhsjstemp=" + machdata_rhsjstemp
				+ ", machdata_rhscstemp=" + machdata_rhscstemp + ", machdata_rhspumpstatus=" + machdata_rhspumpstatus
				+ ", machdata_rhstempset=" + machdata_rhstempset + ", machdata_rhstempturn=" + machdata_rhstempturn
				+ ", machdata_lowpressure1=" + machdata_lowpressure1 + ", machdata_lowpressure2="
				+ machdata_lowpressure2 + ", machdata_lowpressure3=" + machdata_lowpressure3
				+ ", machdata_lowpressure4=" + machdata_lowpressure4 + ", machdata_highpressure1="
				+ machdata_highpressure1 + ", machdata_highpressure2=" + machdata_highpressure2
				+ ", machdata_highpressure3=" + machdata_highpressure3 + ", machdata_highpressure4="
				+ machdata_highpressure4 + ", machdata_compressor1speed=" + machdata_compressor1speed
				+ ", machdata_compressor2speed=" + machdata_compressor2speed + ", machdata_compressor3speed="
				+ machdata_compressor3speed + ", machdata_compressor4speed=" + machdata_compressor4speed
				+ ", machdata_compressor5speed=" + machdata_compressor5speed + ", machdata_compressor6speed="
				+ machdata_compressor6speed + ", machdata_compressor7speed=" + machdata_compressor7speed
				+ ", machdata_compressor8speed=" + machdata_compressor8speed + ", machdata_compressoravg1="
				+ machdata_compressoravg1 + ", machdata_compressoravg2=" + machdata_compressoravg2
				+ ", machdata_createtime=" + machdata_createtime + ", machdata_updatetime=" + machdata_updatetime
				+ ", machdata_updateman=" + machdata_updateman + ", machdata_readtime=" + machdata_readtime
				+ ", machdata_readtype=" + machdata_readtype + ", getMachdata_id()=" + getMachdata_id()
				+ ", getMachdata_machcode()=" + getMachdata_machcode() + ", getMachdata_status()="
				+ getMachdata_status() + ", getMachdata_airtemp()=" + getMachdata_airtemp()
				+ ", getMachdata_watertemp()=" + getMachdata_watertemp() + ", getMachdata_pump2status()="
				+ getMachdata_pump2status() + ", getMachdata_summertemp()=" + getMachdata_summertemp()
				+ ", getMachdata_wintertemp()=" + getMachdata_wintertemp() + ", getMachdata_zfqjstemp()="
				+ getMachdata_zfqjstemp() + ", getMachdata_zfqcstemp()=" + getMachdata_zfqcstemp()
				+ ", getMachdata_zfqpump1status()=" + getMachdata_zfqpump1status() + ", getMachdata_zfqpump2status()="
				+ getMachdata_zfqpump2status() + ", getMachdata_zfqwatertempset()=" + getMachdata_zfqwatertempset()
				+ ", getMachdata_lnqjstemp()=" + getMachdata_lnqjstemp() + ", getMachdata_lnqcstemp()="
				+ getMachdata_lnqcstemp() + ", getMachdata_lnqpumpstatus()=" + getMachdata_lnqpumpstatus()
				+ ", getMachdata_rhsjstemp()=" + getMachdata_rhsjstemp() + ", getMachdata_rhscstemp()="
				+ getMachdata_rhscstemp() + ", getMachdata_rhspumpstatus()=" + getMachdata_rhspumpstatus()
				+ ", getMachdata_rhstempset()=" + getMachdata_rhstempset() + ", getMachdata_rhstempturn()="
				+ getMachdata_rhstempturn() + ", getMachdata_lowpressure1()=" + getMachdata_lowpressure1()
				+ ", getMachdata_lowpressure2()=" + getMachdata_lowpressure2() + ", getMachdata_lowpressure3()="
				+ getMachdata_lowpressure3() + ", getMachdata_lowpressure4()=" + getMachdata_lowpressure4()
				+ ", getMachdata_highpressure1()=" + getMachdata_highpressure1() + ", getMachdata_highpressure2()="
				+ getMachdata_highpressure2() + ", getMachdata_highpressure3()=" + getMachdata_highpressure3()
				+ ", getMachdata_highpressure4()=" + getMachdata_highpressure4() + ", getMachdata_compressor1speed()="
				+ getMachdata_compressor1speed() + ", getMachdata_compressor2speed()=" + getMachdata_compressor2speed()
				+ ", getMachdata_compressor3speed()=" + getMachdata_compressor3speed()
				+ ", getMachdata_compressor4speed()=" + getMachdata_compressor4speed()
				+ ", getMachdata_compressor5speed()=" + getMachdata_compressor5speed()
				+ ", getMachdata_compressor6speed()=" + getMachdata_compressor6speed()
				+ ", getMachdata_compressor7speed()=" + getMachdata_compressor7speed()
				+ ", getMachdata_compressor8speed()=" + getMachdata_compressor8speed()
				+ ", getMachdata_compressoravg1()=" + getMachdata_compressoravg1() + ", getMachdata_compressoravg2()="
				+ getMachdata_compressoravg2() + ", getMachdata_createtime()=" + getMachdata_createtime()
				+ ", getMachdata_updatetime()=" + getMachdata_updatetime() + ", getMachdata_updateman()="
				+ getMachdata_updateman() + ", getMachdata_readtime()=" + getMachdata_readtime()
				+ ", getMachdata_readtype()=" + getMachdata_readtype() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
