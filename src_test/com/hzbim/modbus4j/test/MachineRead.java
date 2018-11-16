package com.hzbim.modbus4j.test;

import java.util.Date;

import com.hzbim.modbus4j.pojo.machinedata;
import com.serotonin.modbus4j.BatchRead;
import com.serotonin.modbus4j.BatchResults;
import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.code.DataType;
import com.serotonin.modbus4j.exception.ErrorResponseException;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.locator.BaseLocator;
import com.serotonin.modbus4j.test.SerialPortWrapperImpl;

public class MachineRead {

	/**
	 * 工厂。
	 */
	static ModbusFactory modbusFactory;

	static {
		if (modbusFactory == null) {
			modbusFactory = new ModbusFactory();
		}
	}

	/**
	 * 获取master
	 * 
	 * @throws ModbusInitException
	 */
	public static ModbusMaster getMaster() throws ModbusInitException {
		String commPortId = "COM3";
		int baudRate = 9600;
		int flowControlIn = 0;
		int flowControlOut = 0;
		int dataBits = 8;
		int stopBits = 1;
		int parity = 0;

		SerialPortWrapperImpl wrapper = new SerialPortWrapperImpl(commPortId, baudRate, dataBits, stopBits, parity,
				flowControlIn, flowControlOut);

		ModbusMaster master = new ModbusFactory().createRtuMaster(wrapper);

		master.setTimeout(2000);
		master.setRetries(1);

		master.init();

		return master;
	}

	/**
	 * 读取[01 Coil Status 0x]类型 开关数据
	 * 
	 * @param slaveId
	 *            slaveId
	 * @param offset
	 *            位置
	 * @return 读取值
	 * @throws ModbusTransportException
	 *             异常
	 * @throws ErrorResponseException
	 *             异常
	 * @throws ModbusInitException
	 *             异常
	 */
	public static Boolean readCoilStatus(int slaveId, int offset)
			throws ModbusTransportException, ErrorResponseException, ModbusInitException {
		// 01 Coil Status
		BaseLocator<Boolean> loc = BaseLocator.coilStatus(slaveId, offset);
		Boolean value = getMaster().getValue(loc);
		return value;
	}

	/**
	 * 读取[02 Input Status 1x]类型 开关数据
	 * 
	 * @param slaveId
	 * @param offset
	 * @return
	 * @throws ModbusTransportException
	 * @throws ErrorResponseException
	 * @throws ModbusInitException
	 */
	public static Boolean readInputStatus(int slaveId, int offset)
			throws ModbusTransportException, ErrorResponseException, ModbusInitException {
		// 02 Input Status
		BaseLocator<Boolean> loc = BaseLocator.inputStatus(slaveId, offset);
		Boolean value = getMaster().getValue(loc);
		return value;
	}

	/**
	 * 读取[03 Holding Register类型 2x]模拟量数据
	 * 
	 * @param slaveId
	 *            slave Id
	 * @param offset
	 *            位置
	 * @param dataType
	 *            数据类型,来自com.serotonin.modbus4j.code.DataType
	 * @return
	 * @throws ModbusTransportException
	 *             异常
	 * @throws ErrorResponseException
	 *             异常
	 * @throws ModbusInitException
	 *             异常
	 */
	public static Number readHoldingRegister(int slaveId, int offset, int dataType)
			throws ModbusTransportException, ErrorResponseException, ModbusInitException {
		// 03 Holding Register类型数据读取
		BaseLocator<Number> loc = BaseLocator.holdingRegister(slaveId, offset, dataType);
		Number value = getMaster().getValue(loc);
		return value;
	}

	/**
	 * 读取[04 Input Registers 3x]类型 模拟量数据
	 * 
	 * @param slaveId
	 *            slaveId
	 * @param offset
	 *            位置
	 * @param dataType
	 *            数据类型,来自com.serotonin.modbus4j.code.DataType
	 * @return 返回结果
	 * @throws ModbusTransportException
	 *             异常
	 * @throws ErrorResponseException
	 *             异常
	 * @throws ModbusInitException
	 *             异常
	 */
	public static Number readInputRegisters(int slaveId, int offset, int dataType)
			throws ModbusTransportException, ErrorResponseException, ModbusInitException {
		// 04 Input Registers类型数据读取
		BaseLocator<Number> loc = BaseLocator.inputRegister(slaveId, offset, dataType);
		Number value = getMaster().getValue(loc);
		return value;
	}

	/**
	 * 批量读取使用方法
	 * 
	 * @throws ModbusTransportException
	 * @throws ErrorResponseException
	 * @throws ModbusInitException
	 */
	public static void batchRead() throws ModbusTransportException, ErrorResponseException, ModbusInitException {

		BatchRead<Integer> batch = new BatchRead<Integer>();

		batch.addLocator(0, BaseLocator.holdingRegister(1, 1, DataType.FOUR_BYTE_FLOAT));
		batch.addLocator(1, BaseLocator.inputStatus(1, 0));

		ModbusMaster master = getMaster();

		batch.setContiguousRequests(false);
		BatchResults<Integer> results = master.send(batch);
		System.out.println(results.getValue(0));
		System.out.println(results.getValue(1));
	}

	/**
	 * 测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		machinedata data=new machinedata();
		
		try {
			///008	B	IN / OUT	Comando On/Off da supervisore (0:Off - 1:On)从监控协议开关机组命令（0：关机—1：开机）
			

			data.setMachdata_id(1);//主键
			data.setMachdata_machcode("NO1");//机器代码
			
			BatchRead<Integer> batch = new BatchRead<Integer>();

			batch.addLocator(0, BaseLocator.holdingRegister(1, 1, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.holdingRegister(1, 2, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.holdingRegister(1, 3, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.holdingRegister(1, 4, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.holdingRegister(1, 5, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.holdingRegister(1, 6, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.holdingRegister(1, 7, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.holdingRegister(1, 8, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.holdingRegister(1, 9, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.holdingRegister(1, 10, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.holdingRegister(1, 11, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.holdingRegister(1, 12, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.holdingRegister(1, 13, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.holdingRegister(1, 14, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.holdingRegister(1, 15, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.holdingRegister(1, 16, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.holdingRegister(1, 17, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.holdingRegister(1, 18, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.holdingRegister(1, 19, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.holdingRegister(1, 21, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.holdingRegister(1, 22, DataType.FOUR_BYTE_FLOAT));
			
			batch.addLocator(1, BaseLocator.coilStatus(1, 1));
			batch.addLocator(1, BaseLocator.coilStatus(1, 3));
			batch.addLocator(1, BaseLocator.coilStatus(1, 4));
			batch.addLocator(1, BaseLocator.coilStatus(1, 5));
			batch.addLocator(1, BaseLocator.coilStatus(1, 6));
			batch.addLocator(1, BaseLocator.coilStatus(1, 7));
			
			batch.addLocator(0, BaseLocator.inputRegister(1, 23, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.inputRegister(1, 24, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.inputRegister(1, 46, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.inputRegister(1, 47, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.inputRegister(1, 48, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.inputRegister(1, 49, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.inputRegister(1, 50, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.inputRegister(1, 51, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.inputRegister(1, 52, DataType.FOUR_BYTE_FLOAT));
			batch.addLocator(0, BaseLocator.inputRegister(1, 53, DataType.FOUR_BYTE_FLOAT));
			

			ModbusMaster master = getMaster();

			batch.setContiguousRequests(false);
			BatchResults<Integer> results = master.send(batch);
			
			
			//A类型的数据读数
			data.setMachdata_summertemp(Float.parseFloat(results.getValue(0).toString()));//夏季温度设定点	-001	A	IN / OUT	Setpoint temperatura estivo夏季温度设定点
			data.setMachdata_wintertemp(Float.parseFloat(results.getValue(1).toString()));//冬季温度设定点	-002	A	IN / OUT	Setpoint temperatura invernale冬季温度设定点
			data.setMachdata_rhstempset(Float.parseFloat(results.getValue(2).toString()));//热回收水温度设定-003	A	IN / OUT	Setpoint recupero回收水温度设定点
			data.setMachdata_zfqwatertempset(Float.parseFloat(results.getValue(3).toString()));//蒸发器水温度带设定-004	A	IN / OUT	Banda regolazione temperatura蒸发器水温度调节比例带设定
			data.setMachdata_rhstempturn(Float.parseFloat(results.getValue(4).toString()));//热回收水温度调节比率-005	A	IN / OUT	Banda regolazione recupero回收水温度调节比例带设定
			data.setMachdata_zfqjstemp(Float.parseFloat(results.getValue(5).toString()));//蒸发器进水温度	-006	A	OUT	Temperatura ingresso evaporatore蒸发器进水温度
			data.setMachdata_zfqcstemp(Float.parseFloat(results.getValue(6).toString()));//蒸发器出水温度	-007	A	OUT	Temperatura uscita (media) evaporatore蒸发器出水温度（平均）
			data.setMachdata_lnqjstemp(Float.parseFloat(results.getValue(7).toString()));//冷凝器进水温度	-008	A	OUT	Temperatura ingresso condensatore冷凝器进水温度
			data.setMachdata_lnqcstemp(Float.parseFloat(results.getValue(8).toString()));//冷凝器出水温度	-009	A	OUT	Temperatura uscita (media) condensatore冷凝器出水温度（平均）
			data.setMachdata_rhsjstemp(Float.parseFloat(results.getValue(9).toString()));//热回收进水温度	-010	A	OUT	Temperatura ingresso recupero热回收进水温度
			data.setMachdata_rhscstemp(Float.parseFloat(results.getValue(10).toString()));//热回收出水温度	-011	A	OUT	Temperatura uscita recupero热回收出水温度
			data.setMachdata_highpressure1(Float.parseFloat(results.getValue(11).toString()));//高压压力1	-012	A	OUT	Trasduttore alta pressione 1高压压力传感器压力值1
			data.setMachdata_highpressure2(Float.parseFloat(results.getValue(12).toString()));//高压压力2	-013	A	OUT	Trasduttore alta pressione 2高压压力传感器压力值2
			data.setMachdata_highpressure3(Float.parseFloat(results.getValue(13).toString()));//高压压力3	-014	A	OUT	Trasduttore alta pressione 3高压压力传感器压力值3
			data.setMachdata_highpressure4(Float.parseFloat(results.getValue(14).toString()));//高压压力4	-015	A	OUT	Trasduttore alta pressione 4高压压力传感器压力值4
			data.setMachdata_lowpressure1(Float.parseFloat(results.getValue(15).toString()));//低压压力1	-016	A	OUT	Trasduttore bassa pressione 1低压压力传感器压力值1
			data.setMachdata_lowpressure2(Float.parseFloat(results.getValue(16).toString()));//低压压力2	-017	A	OUT	Trasduttore bassa pressione 2低压压力传感器压力值2
			data.setMachdata_lowpressure3(Float.parseFloat(results.getValue(17).toString()));//低压压力3	-018	A	OUT	Trasduttore bassa pressione 3低压压力传感器压力值3
			data.setMachdata_lowpressure4(Float.parseFloat(results.getValue(18).toString()));//低压压力4	-019	A	OUT	Trasduttore bassa pressione 4低压压力传感器压力值4
			data.setMachdata_airtemp(Float.parseFloat(results.getValue(19).toString()));//外部环境温度		-020	A	OUT	Temperatura aria esterna外部环境温度
			data.setMachdata_watertemp(Float.parseFloat(results.getValue(20).toString()));//自然冷却进水温度-022		A	OUT	Temperatura ingresso freecooling自然冷却进水温度
			
			
			//B类型的数据读数
			data.setMachdata_status(Integer.parseInt(results.getValue(21).toString()));//机组状态				-001	B	OUT	Stato unità (0:Off - 1:On)机组状态（0：关机—1：开机）
			data.setMachdata_zfqpump1status(Integer.parseInt(results.getValue(22).toString()));//蒸发器水泵1状态-003	B	OUT	Stato pompa 1 evaporatore (0:Off - 1:On)蒸发器水泵1状态（0：关—1：开）
			data.setMachdata_zfqpump2status(Integer.parseInt(results.getValue(23).toString()));//蒸发器水泵2状态-004	B	OUT	Stato pompa 2 evaporatore (0:Off - 1:On) 蒸发器水泵2状态（0：关—1：开）
			data.setMachdata_rhspumpstatus(Integer.parseInt(results.getValue(24).toString()));//热回收水泵状态	-005	B	OUT	Stato pompa recuperatore (0:Off - 1:On) 热回收水泵状态（0：关—1：开）
			data.setMachdata_lnqpumpstatus(Integer.parseInt(results.getValue(25).toString()));//冷凝器水泵状态	-006	B	OUT	Stato pompa condensatore (0:Off - 1:On) 冷凝器水泵状态（0：关—1：开）
			data.setMachdata_pump2status(Integer.parseInt(results.getValue(26).toString()));//第二水泵状态		-007	B	OUT	Stato pompa secondario (0:Off - 1:On)第二水泵状态（0：关—1：开）
			
			
			//I类型的数据读数
			data.setMachdata_compressoravg1(Float.parseFloat(results.getValue(27).toString()));//压缩机平均时数1	-023	I	OUT	Media ore compressori (migliaia)压缩机的平均运行时数
			data.setMachdata_compressoravg2(Float.parseFloat(results.getValue(28).toString()));//压缩机平均时数2	-024	I	OUT	Media ore compressori (unità) 压缩机的平均运行时数
			data.setMachdata_compressor1speed(Float.parseFloat(results.getValue(29).toString()));//压缩机1转速		-046	I	OUT	Numero giri compressore 1压缩机1转速
			data.setMachdata_compressor2speed(Float.parseFloat(results.getValue(30).toString()));//压缩机2转速		-047	I	OUT	Numero giri compressore 2压缩机2转速
			data.setMachdata_compressor3speed(Float.parseFloat(results.getValue(31).toString()));//压缩机3转速		-048	I	OUT	Numero giri compressore 3压缩机3转速
			data.setMachdata_compressor4speed(Float.parseFloat(results.getValue(32).toString()));//压缩机4转速		-049	I	OUT	Numero giri compressore 4压缩机4转速
			data.setMachdata_compressor5speed(Float.parseFloat(results.getValue(33).toString()));//压缩机5转速		-050	I	OUT	Numero giri compressore 5压缩机5转速
			data.setMachdata_compressor6speed(Float.parseFloat(results.getValue(34).toString()));//压缩机6转速		-051	I	OUT	Numero giri compressore 6压缩机6转速
			data.setMachdata_compressor7speed(Float.parseFloat(results.getValue(35).toString()));//压缩机7转速		-052	I	OUT	Numero giri compressore 7压缩机7转速
			data.setMachdata_compressor8speed(Float.parseFloat(results.getValue(36).toString()));//压缩机8转速		-053	I	OUT	Numero giri compressore 8压缩机8转速
			
			
			data.setMachdata_createtime(new Date());//创建时间
			data.setMachdata_updatetime(new Date());//修改时间
			data.setMachdata_updateman("user id");//修改人员
			data.setMachdata_readtime(new Date());//读数时间
			data.setMachdata_readtype(1);//读数类型，0-定时，1=抄表,2=设置

			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void test1()
	{
		try
		{
			// 01测试
			Boolean v011 = readCoilStatus(1, 0);
//			Boolean v012 = readCoilStatus(1, 1);
//			Boolean v013 = readCoilStatus(1, 6);
			System.out.println("v011:" + v011);
//			System.out.println("v012:" + v012);
//			System.out.println("v013:" + v013);
//			// 02测试
			Boolean v021 = readInputStatus(1, 0);
//			Boolean v022 = readInputStatus(1, 1);
//			Boolean v023 = readInputStatus(1, 2);
			System.out.println("v021:" + v021);
//			System.out.println("v022:" + v022);
//			System.out.println("v023:" + v023);
//
//			// 03测试
			Number v031 = readHoldingRegister(1, 1, DataType.FOUR_BYTE_FLOAT);// 注意,float
//			Number v032 = readHoldingRegister(1, 3, DataType.FOUR_BYTE_FLOAT);// 同上
			System.out.println("v031:" + v031);
//			System.out.println("v032:" + v032);
//
//			// 04测试
			Number v041 = readInputRegisters(1, 1, DataType.FOUR_BYTE_FLOAT);//
//			Number v042 = readInputRegisters(1, 3, DataType.FOUR_BYTE_FLOAT);//
			System.out.println("v041:" + v041);
//			System.out.println("v042:" + v042);
//			// 批量读取
//			batchRead();
			//System.out.println("111");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
