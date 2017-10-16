package gjp.view;

import gip.domain.ZhangWu;
import gjp.service.ZhangWuService;

import java.util.List;
import java.util.Scanner;

/*
 * 添加一个类型为ZhangWuService的成员变量，
 * 因为本项目中view依赖service
 */

public class MainView {
	private ZhangWuService service = new ZhangWuService();
	private static final Scanner in = new Scanner(System.in);
	
	/*
	 * run方法：
	 * 1.完成功能界面菜单显示
	 * 2.接收键盘收入的功能选项
	 * 3.根据选项值，调用对应的功能方法
	 */
	public void run() {
		boolean flag = true;
		
		while(flag) {			
			System.out.println("---------------管家婆家庭记账软件---------------");
			System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
			System.out.print("请输入要操作的功能序号[1-5]: ");
			
			int i = in.nextInt();
			
			switch (i) {
			case 1:
				//添加账务
				addZhangWu();
				break;
				
			case 2:
				//编辑账务
				editZhangWu();
				break;
				
			case 3:
				//删除账务
				deleteZhangWu();
				break;
				
			case 4:
				//查询账务
				selectZhangWu();
				break;
				
			case 5:
				//退出系统
				System.out.println("bye");
				flag = false;
				break;

			default:
				System.out.println("请输入指定数字！");
				break;
			}
		}
		in.close();
	}
	
	private void deleteZhangWu() {
		selectAll();
		System.out.print("请输入要删除的账务的ID：");
		int zwid = in.nextInt();
		
		service.deleteZhangWu(zwid);
	}

	private void editZhangWu() {
		selectAll();
		ZhangWu zw = new ZhangWu();
		
		System.out.print("请输入要修改的账务的ID：");
		zw.setZwid(in.nextInt());
		System.out.print("请输入类别：");
		zw.setFlname(in.next());
		System.out.print("请输入账户：");
		zw.setZhangHu(in.next());
		System.out.print("请输入金额：");
		zw.setMoney(in.nextDouble());
		System.out.print("请输入时间：");
		zw.setCreatetime(in.next());
		System.out.print("请输入说明：");
		zw.setDescription(in.next());
		
		service.editZhangWu(zw);
	}

	private void addZhangWu() {
		ZhangWu zw = new ZhangWu();
		
		System.out.print("请输入类别：");
		zw.setFlname(in.next());
		System.out.print("请输入账户：");
		zw.setZhangHu(in.next());
		System.out.print("请输入金额：");
		zw.setMoney(in.nextDouble());
		System.out.print("请输入时间：");
		zw.setCreatetime(in.next());
		System.out.print("请输入说明：");
		zw.setDescription(in.next());
		
		service.addZhangWu(zw);
	}

	/*
	 * 通过输出语句，显示出要查询账务的方式
	 * 接收键盘的输入项，调用对应的方法（1.查询所有　2.按条件查询）
	 */
	private void selectZhangWu() {
		System.out.print("请选择查询账务的方式, 1.查询所有　2.按条件查询: ");
		int i = in.nextInt();
		if(i == 1)
			//调用查询所有方法
			selectAll();
		else if(i == 2)
			//调用条件查询方法
			select();
		else{
			return;
		}
		//in.close();这玩意儿不能关啊我去,只能在整个程序结尾关
	}

	private void select() {
		System.out.println("请输入查询的日期区间（XXXX-XX-XX格式）");
		System.out.print("起始时间：");
		String start = in.next();
		System.out.print("截止时间：");
		String end = in.next();
		
		List<ZhangWu> list = service.select(start, end);
		print(list);
	}

	private void selectAll() {
		List<ZhangWu> list = service.selectAll();
		//对结果集进行打印
		print(list);
	}

	private void print(List<ZhangWu> list) {
		System.out.println("ID\t类别\t\t账户\t\t金额\t\t时间\t\t说明");
		for(ZhangWu zw: list) {
			System.out.println(zw.getZwid()+"\t"+zw.getFlname()+"\t\t"+zw.getZhangHu()+"\t\t"+zw.getMoney()
					+"\t\t"+zw.getCreatetime()+"\t"+zw.getDescription());
		}
	}
}
