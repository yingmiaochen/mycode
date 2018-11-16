package com.serotonin.modbus4j.test;

import java.util.Arrays;
import java.util.List;

import com.serotonin.modbus4j.BatchRead;
import com.serotonin.modbus4j.BatchResults;
import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.code.DataType;
import com.serotonin.modbus4j.code.RegisterRange;
import com.serotonin.modbus4j.exception.ErrorResponseException;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.ip.IpParameters;
import com.serotonin.modbus4j.locator.BaseLocator;
import com.serotonin.modbus4j.locator.NumericLocator;
import com.serotonin.modbus4j.msg.ReadHoldingRegistersRequest;
import com.serotonin.modbus4j.msg.ReadHoldingRegistersResponse;

import com.serotonin.modbus4j.test.SerialPortWrapperImpl;

public class Test5 {
	
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
	 * @return
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
    
				
		SerialPortWrapperImpl wrapper=new SerialPortWrapperImpl(commPortId, baudRate, dataBits, stopBits, parity, flowControlIn, flowControlOut);
	
        ModbusMaster master = new ModbusFactory().createRtuMaster(wrapper);
        
        master.setTimeout(8000);
        master.setRetries(200);
        
        master.init();
		
		return master;
	}
	

	public static void main(String[] args) throws Exception {

    	
		ModbusMaster master=getMaster();
		
		BaseLocator<Number> loc = BaseLocator.holdingRegister(1, 0, DataType.TWO_BYTE_INT_SIGNED);
		Number value = master.getValue(loc);
		System.out.println("Testing value1=" + value + " ");
		
		loc = BaseLocator.holdingRegister(1, 1, DataType.TWO_BYTE_INT_SIGNED);
		System.out.println("Testing value2=" + master.getValue(loc) + " ");
		
		loc = BaseLocator.holdingRegister(1, 2, DataType.TWO_BYTE_INT_SIGNED);
		System.out.println("Testing value3=" + master.getValue(loc) + " ");
		
		//loc = BaseLocator.inputRegister(1, 1, DataType.FOUR_BYTE_FLOAT);
		//System.out.println("Testing value4=" + master.getValue(loc) + " ");
		
		
		
		
        //readHoldingRegistersTest(master,1,0,8);
        
//       for (int i = 0; i < 5; i++) {
//           long start = System.currentTimeMillis();
//            System.out.print("Testing " + i + "... ");
//           System.out.println(getMaster().testSlaveNode(i));
//            System.out.println("Time: " + (System.currentTimeMillis() - start));
//        }
//        
        

        master.destroy();
    }
	
	/**
     * 读保持寄存器上的内容
     * @param master 主站
     * @param slaveId 从站地址
     * @param start 起始地址的偏移量
     * @param len 待读寄存器的个数
     */
    private static void readHoldingRegistersTest(ModbusMaster master, int slaveId, int start, int len) {
        try {
            ReadHoldingRegistersRequest request = new ReadHoldingRegistersRequest(slaveId, start, len);
            ReadHoldingRegistersResponse response = (ReadHoldingRegistersResponse) master.send(request);
 
            if (response.isException())
                System.out.println("Exception response: message=" + response.getExceptionMessage());
            else
                System.out.println(Arrays.toString(response.getShortData()));
        }
        catch (ModbusTransportException e) {
            e.printStackTrace();
        }
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
}
