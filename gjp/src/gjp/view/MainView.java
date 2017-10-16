package gjp.view;

import gip.domain.ZhangWu;
import gjp.service.ZhangWuService;

import java.util.List;
import java.util.Scanner;

/*
 * ���һ������ΪZhangWuService�ĳ�Ա������
 * ��Ϊ����Ŀ��view����service
 */

public class MainView {
	private ZhangWuService service = new ZhangWuService();
	private static final Scanner in = new Scanner(System.in);
	
	/*
	 * run������
	 * 1.��ɹ��ܽ���˵���ʾ
	 * 2.���ռ�������Ĺ���ѡ��
	 * 3.����ѡ��ֵ�����ö�Ӧ�Ĺ��ܷ���
	 */
	public void run() {
		boolean flag = true;
		
		while(flag) {			
			System.out.println("---------------�ܼ��ż�ͥ�������---------------");
			System.out.println("1.�������2.�༭����3.ɾ������4.��ѯ����5.�˳�ϵͳ");
			System.out.print("������Ҫ�����Ĺ������[1-5]: ");
			
			int i = in.nextInt();
			
			switch (i) {
			case 1:
				//�������
				addZhangWu();
				break;
				
			case 2:
				//�༭����
				editZhangWu();
				break;
				
			case 3:
				//ɾ������
				deleteZhangWu();
				break;
				
			case 4:
				//��ѯ����
				selectZhangWu();
				break;
				
			case 5:
				//�˳�ϵͳ
				System.out.println("bye");
				flag = false;
				break;

			default:
				System.out.println("������ָ�����֣�");
				break;
			}
		}
		in.close();
	}
	
	private void deleteZhangWu() {
		selectAll();
		System.out.print("������Ҫɾ���������ID��");
		int zwid = in.nextInt();
		
		service.deleteZhangWu(zwid);
	}

	private void editZhangWu() {
		selectAll();
		ZhangWu zw = new ZhangWu();
		
		System.out.print("������Ҫ�޸ĵ������ID��");
		zw.setZwid(in.nextInt());
		System.out.print("���������");
		zw.setFlname(in.next());
		System.out.print("�������˻���");
		zw.setZhangHu(in.next());
		System.out.print("�������");
		zw.setMoney(in.nextDouble());
		System.out.print("������ʱ�䣺");
		zw.setCreatetime(in.next());
		System.out.print("������˵����");
		zw.setDescription(in.next());
		
		service.editZhangWu(zw);
	}

	private void addZhangWu() {
		ZhangWu zw = new ZhangWu();
		
		System.out.print("���������");
		zw.setFlname(in.next());
		System.out.print("�������˻���");
		zw.setZhangHu(in.next());
		System.out.print("�������");
		zw.setMoney(in.nextDouble());
		System.out.print("������ʱ�䣺");
		zw.setCreatetime(in.next());
		System.out.print("������˵����");
		zw.setDescription(in.next());
		
		service.addZhangWu(zw);
	}

	/*
	 * ͨ�������䣬��ʾ��Ҫ��ѯ����ķ�ʽ
	 * ���ռ��̵���������ö�Ӧ�ķ�����1.��ѯ���С�2.��������ѯ��
	 */
	private void selectZhangWu() {
		System.out.print("��ѡ���ѯ����ķ�ʽ, 1.��ѯ���С�2.��������ѯ: ");
		int i = in.nextInt();
		if(i == 1)
			//���ò�ѯ���з���
			selectAll();
		else if(i == 2)
			//����������ѯ����
			select();
		else{
			return;
		}
		//in.close();����������ܹذ���ȥ,ֻ�������������β��
	}

	private void select() {
		System.out.println("�������ѯ���������䣨XXXX-XX-XX��ʽ��");
		System.out.print("��ʼʱ�䣺");
		String start = in.next();
		System.out.print("��ֹʱ�䣺");
		String end = in.next();
		
		List<ZhangWu> list = service.select(start, end);
		print(list);
	}

	private void selectAll() {
		List<ZhangWu> list = service.selectAll();
		//�Խ�������д�ӡ
		print(list);
	}

	private void print(List<ZhangWu> list) {
		System.out.println("ID\t���\t\t�˻�\t\t���\t\tʱ��\t\t˵��");
		for(ZhangWu zw: list) {
			System.out.println(zw.getZwid()+"\t"+zw.getFlname()+"\t\t"+zw.getZhangHu()+"\t\t"+zw.getMoney()
					+"\t\t"+zw.getCreatetime()+"\t"+zw.getDescription());
		}
	}
}
