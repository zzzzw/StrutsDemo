package dao;

import java.util.ArrayList;
import java.util.List;

//模拟DAO，实际处理业务，与数据库打交道的
public class DataDAO {

	// 返回符合条件的所有车次
	public static List<String[]> getcclist(String sfz, String ddz) {
		System.out.println("接受的参数为：" + sfz);
		System.out.println("接受的参数为：" + ddz);

		// 模拟数据
		List<String[]> result = new ArrayList();

		String[] s = new String[5];
		s[0] = "T122";
		s[1] = "北京";
		s[2] = "海南";
		s[3] = "3个小时";
		s[4] = "200张";

		result.add(s);

		String[] s2 = new String[5];
		s2[0] = "D526";
		s2[1] = "武汉";
		s2[2] = "香港";
		s2[3] = "1个小时";
		s2[4] = "20张";

		result.add(s2);

		return result;
	}

	// 返回当前登录用户下的所有自己的常用乘客姓名
	public static List<String> getcklist(String user) {
		List<String> list = new ArrayList<String>();
		list.add("z张全雄");
		list.add("杰豪");
		list.add("张明");
		list.add("李刚");
		list.add("习近平");
		list.add("李克强");
		list.add("王岐山");
		list.add("张无忌");

		return list;
	}

	// 根据选择的用户，返回订单的详细信息
	public static List<String[]> getqdlist(String gxcknames) {
		List<String[]> r = new ArrayList();

		if (gxcknames != null) {

			String[] names = gxcknames.split(",");
			for (int i = 0; i < names.length; i++) {
				String[] s = new String[4];
				// 有指定的算法
				s[0] = names[i].trim();
				s[1] = s[0] + "选择的硬卧";
				s[2] = Integer.toString((int) (Math.random() * 100));
				s[3] = Integer.toString(Integer.parseInt(s[2]) * 100);

				r.add(s);
			}
		}
		return r;
	}

}
