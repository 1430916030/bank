package bank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jieji {
	public static void jieji() {
		final String USER_NAME = "zhangsan";// �û���
		final String PASSWORD = "123456";// ����

		while (true) {
			System.out.print("�������û�����");
			String user_name = getString();
			System.out.print("���������룺");
			String password = getString();
			if (user_name != null && user_name.equals(USER_NAME)
					&& password != null && password.equals(PASSWORD)) {
				System.out.println("��½�ɹ�����Ҫ��ʲô��");
				while (true) {
					System.out.println("1�����");
					System.out.println("2��ȡ��");
					System.out.println("3����ѯ���");
					System.out.println("q���˳�����");
					System.out.print("��ѡ��");
					String userIn = getString();
					int in = 0;
					if (userIn != null && userIn.equals("1")) {
						in = Integer.parseInt(userIn);
					} else if (userIn != null && userIn.equals("2")) {
						in = Integer.parseInt(userIn);
					} else if (userIn != null && userIn.equals("3")) {
						in = Integer.parseInt(userIn);
					} else if (userIn != null
							&& userIn.trim().toUpperCase().equals("Q")) {
						in = 4;
					} else {
						System.out.println("�������ָ���ȷ�����������롣");
						continue;
					}
					double MONEY = 0;
					switch (in) {
					case 1:
						double add_money = 0;
						while (true) {
							System.out.print("��������Ҫ����Ľ�");
							try {
								add_money = Double.parseDouble(getString());
							} catch (Exception e) {
								System.out.println("������벻��ȷ��");
								continue;
							}
							break;
						}
						MONEY+= add_money;
						System.out.println("����Ľ����" + add_money
								+ "\r\n��ѡ����Ҫ�Ĳ�����");
						break;
					case 2:
						double money = 0;
						while (true) {
							System.out.print("��������Ҫȡ���Ľ�");
							try {
								money = Double.parseDouble(getString());
							} catch (Exception e) {
								System.out.println("������벻��ȷ��");
								continue;
							}
							if (money > MONEY) {
								System.out.println("ȡ���Ľ��������д�����������Ҫȡ���Ľ�");
								continue;
							}
							break;
						}
						MONEY -= money;
						System.out.println("ȡ���Ľ����" + money + "\r\n��ѡ����Ҫ�Ĳ�����");
						break;
					case 3:
						System.out.println("�������ǣ�" + MONEY + "\r\n��ѡ����Ҫ�Ĳ�����");
						break;
					case 4:
						System.out.println("�����˳���");
						return;
					}
				}

			} else {
				System.out.println("�����û��������벻ƥ�䣡\r\n");
				System.out.println("�������:���������û��������롣");
				System.out.println("q:�˳�����");
				System.out.print("��ѡ��:");
				String in = getString();
				if (in.trim().toUpperCase().equals("Q")) {
					break;
				}
			}
		}
	}

	public static String getString() {
		String str = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}

