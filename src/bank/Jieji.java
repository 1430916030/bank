package bank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jieji {
	public static void jieji() {
		final String USER_NAME = "zhangsan";// 用户名
		final String PASSWORD = "123456";// 密码

		while (true) {
			System.out.print("请输入用户名：");
			String user_name = getString();
			System.out.print("请输入密码：");
			String password = getString();
			if (user_name != null && user_name.equals(USER_NAME)
					&& password != null && password.equals(PASSWORD)) {
				System.out.println("登陆成功！您要干什么？");
				while (true) {
					System.out.println("1：存款");
					System.out.println("2：取款");
					System.out.println("3：查询余额");
					System.out.println("q：退出程序");
					System.out.print("请选择：");
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
						System.out.println("你输入的指令不正确！请重新输入。");
						continue;
					}
					double MONEY = 0;
					switch (in) {
					case 1:
						double add_money = 0;
						while (true) {
							System.out.print("请输入你要存入的金额：");
							try {
								add_money = Double.parseDouble(getString());
							} catch (Exception e) {
								System.out.println("金额输入不正确！");
								continue;
							}
							break;
						}
						MONEY+= add_money;
						System.out.println("存入的金额是" + add_money
								+ "\r\n请选择你要的操作：");
						break;
					case 2:
						double money = 0;
						while (true) {
							System.out.print("请输入你要取出的金额：");
							try {
								money = Double.parseDouble(getString());
							} catch (Exception e) {
								System.out.println("金额输入不正确！");
								continue;
							}
							if (money > MONEY) {
								System.out.println("取出的金额大于现有存款，请重新输入要取出的金额！");
								continue;
							}
							break;
						}
						MONEY -= money;
						System.out.println("取出的金额是" + money + "\r\n请选择你要的操作：");
						break;
					case 3:
						System.out.println("你的余额是：" + MONEY + "\r\n请选择你要的操作：");
						break;
					case 4:
						System.out.println("程序退出！");
						return;
					}
				}

			} else {
				System.out.println("错误：用户名与密码不匹配！\r\n");
				System.out.println("按任意键:重新输入用户名和密码。");
				System.out.println("q:退出程序。");
				System.out.print("请选择:");
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

