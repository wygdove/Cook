package bin;
import java.util.HashSet;
import java.util.Set;

import com.wygdove.final_thecook.R;


import bin.caipu;
import bin.shicai;

public class Data {
	static public shicai sc[] = new shicai[15];
	static public  caipu cp[] = new caipu[25];
	static public HashSet result = new HashSet();
	static public  int img[]=new int [25];
	public Data() {
		shicai sc1 = new shicai(1, "猪肉", new int[] { 1, 2, 7, 11, 14, 19 ,13});
		sc[1] = sc1;
		shicai sc2 = new shicai(2, "笋", new int[] { 1, 4 });
		sc[2] = sc2;
		shicai sc3 = new shicai(3, "木耳", new int[] { 1, 6 });
		sc[3] = sc3;
		shicai sc4 = new shicai(4, "辣椒", new int[] { 2, 4, 7, 8, 9, 10, 12, 14,
				17, 19 });
		sc[4] = sc4;
		shicai sc5 = new shicai(5, "豆腐", new int[] { 3, 4, 7, 9, 10, 11, 20 });
		sc[5] = sc5;
		shicai sc6 = new shicai(6, "鱼肉", new int[] { 3, 6, 12, 16, 20 });
		sc[6] = sc6;
		shicai sc7 = new shicai(7, "胡萝卜", new int[] { 4, 14 });
		sc[7] = sc7;
		shicai sc8 = new shicai(8, "蒜", new int[] { 5, 6, 8, 20 });
		sc[8] = sc8;
		shicai sc9 = new shicai(9, "鸡蛋", new int[] { 5 });
		sc[9] = sc9;
		shicai sc10 = new shicai(10, "茄子", new int[] { 8, 9, 15 });
		sc[10] = sc10;
		shicai sc11 = new shicai(11, "青菜", new int[] { 15, 16 });
		sc[11] = sc11;
		shicai sc12 = new shicai(12, "土豆", new int[] { 17, 18 });
		sc[12] = sc12;
		shicai sc13 = new shicai(13, "大米", new int[] { 13});
		sc[13] = sc13;
		shicai sc14 = new shicai(14, "花生", new int[] { 13});
		sc[14] = sc14;
		
		caipu cp1 = new caipu(1, "鱼香肉丝", "猪里脊肉切丝，用冷水浸泡直至泡出血水，同时黑木耳温水泡发肉丝加入料酒、淀粉、盐、少量植物油腌制半小时\n胡萝卜、笋子、黑木耳切丝待用调配鱼香汁：姜葱蒜切末，加入1勺盐、1勺淀粉、3勺酱油、4勺砂糖、4勺醋、5勺水调匀\n热锅热油倒入肉丝大火炒至肉丝变白\n转中火加入郫县豆瓣酱炒出红油倒入胡萝卜、笋子、黑木耳丝大火翻炒至熟\n倒入调配好的鱼香汁，约一分钟翻炒均匀即可出锅" );
		cp[1] = cp1;
		caipu cp11 = new caipu(11, "豆酱焖肉", 
				"猪肉切大块入凉水锅中焯水，待血水和浮沫出净后捞出\n适量水放入锅中煮沸，加入梅花肉、姜片、八角煮沸后用小火煮约40分钟，取出切块晾凉，汤盛出备用\n3锅中热油，下入切好的梅花肉、蒜蓉、酱油爆香后，调入1小勺料酒，再下入黄豆酱炒匀，加入刚才盛出的肉汤煲滚，转小火焖烂\n约30分钟后，用淀粉水勾芡，下葱花炒匀即可" );
		cp[11] = cp11;

		caipu cp12 = new caipu(
				12,
				"煎炒肉馅辣椒",
						"	准备好鱼肉馅，鱼肉可以跟冬菇，玉米，葱，木耳等搅拌在一起，也可以只有纯鱼肉末。可以自己做，也可以到外面市场买，一般在外面市场买的都需要回来加工，不然会有鱼腥味，我是最受不了鱼腥味的\n把辣椒剖开，把辣椒籽都挖出来，然后把鱼肉装进去。同时把糖，酱油，水混合在一起调成芡汁\n热锅，加油，把准备好的辣椒倒入炒锅里翻炒，上色后转小火，倒入芡汁盖上盖子闷烧一会。\n火焖煮10分钟左右或者芡汁差不过收干就可以了，就可以上碟食用了" );
		cp[12] = cp12;

		caipu cp14 = new caipu(14, "尖椒小炒肉","主辅料： 尖椒、猪肉、胡萝卜\n把猪肉切片\n加适量水淀粉轻轻抓匀上浆\n把尖椒切块、胡萝卜切片\n热油，炒香葱花\n放入浆好肉片，小火炒至肉片发白变色\n放入胡萝卜片翻炒\n加少许生抽\n放入尖椒块\n中小火，均匀翻炒1分钟左右\n加盐调味，炒匀即可关火\n出锅装盘，即可上桌食用" );
		cp[14] = cp14;
		caipu cp15 = new caipu(15, "青菜炒鸡蛋","食材：青菜（已洗净）、鸡蛋（已打入碗中）将已洗净的青菜放在案板上切碎随后，合入鸡蛋\n,接着，加1汤勺料酒加2勺辣椒面加0.5勺盐调味拌匀\n然后，在锅中加入3汤勺油烧热，下入拌好的青菜蛋液翻炒翻炒至熟，即成" );
		cp[15] = cp15;
		caipu cp16 = new caipu(16, "豆腐炒青菜", 
				"食材：油豆腐、青菜（已洗净)将已洗净的青菜放在案板上切开，待用\n将油豆腐放在案板上切开\n在锅中加入3汤勺油烧热，下入切好的青菜和油豆腐翻炒翻炒\n接着，加适量的清水\n翻炒翻炒至青菜断生\n然后，加1勺盐\n加0.5勺味精\n调味炒匀，即可" );
		cp[16] = cp16;
		caipu cp17 = new caipu(17, "青椒炒土豆","青椒清洗干净切成条\n土豆去皮切成条\n锅里油烧热倒入青椒炒\n青椒炒变色后加入土豆丝炒\n加入盐炒匀\n翻炒均匀中间加点水炒匀，防止沾锅\n炒至土豆熟加入鸡精\n大火翻炒一会即可关火" );
		cp[17] = cp17;
		caipu cp18 = new caipu(18, "红咖喱土豆块","主辅料： 土豆、红咖喱、椰浆.土豆去皮洗净，切滚刀块\n热油，放入红咖喱酱\n小火慢慢炒香\n加入椰浆\n烧开后，放入土豆块\n旺火烧开，加少许盐补充提味\n小火烧制8分钟左右，至土豆熟透\n旺火收汁，即可关火\n出锅装盘，即可上桌食用" );
		cp[18] = cp18;
		caipu cp19 = new caipu(19, "椒丝炒肉", 
				"准备食材：五花肉切细条，青红椒切细条，姜切片，葱切小段，将甜面酱、料酒、砂糖和酱油拌匀成调味料\n平底锅放入五花肉条煎成金黄，盛起待用\n炒锅放入少许油，爆香豆豉、姜片和葱段，放入肉丝翻炒一下\n加准备好的调味料，炒匀\n放入青红椒丝，翻炒至食材煮熟即可" );
		cp[19] = cp19;
		caipu cp20 = new caipu(20, "红烧鱼",
				"鱼洗净处理完后抹少许盐腌半个小时，更衣入味\n鱼放入锅后，先大火把鱼身煎得微黄，再煎另一面，煎好后装盘待用\n准备葱段，辣椒 ，蒜和生姜\n把煎好的鱼放入锅内，加水一抹过鱼身为宜，待水烧开后加入2/1勺料酒，一勺酱油，一勺白糖，少许盐\n小火慢炖10分钟，待锅内水快烧干时，然后大火收汁装盘，撒上葱丝\n转中火加入郫县豆瓣酱炒出红油" );
		cp[20] = cp20;

		caipu cp2=new caipu(2, "椒丝炒肉", "准备食材：五花肉切细条，青红椒切细条，姜切片，葱切小段，将甜面酱、料酒、砂糖和酱油拌匀成调味料\n平底锅放入五花肉条煎成金黄，盛起待用\n炒锅放入少许油，爆香豆豉、姜片和葱段，放入肉丝翻炒一下\n加准备好的调味料，炒匀\n放入青红椒丝，翻炒至食材煮熟即可");
		cp[2]=cp2;
		
		
		caipu cp3=new caipu(3, "豆腐烧鱼块", "准备好鱼肉洗净\n加姜丝，料酒，盐，生粉和辣椒酱\n拌匀腌一下\n准备好豆腐\n豆腐切块\n锅热油，下花椒和姜蒜炒香\n加一碗水\n加入鱼块\n加点酱油烧一下\n加鸡精调味\n装盘，撒上香菜和葱末");
		cp[3]=cp3;
		
		
		caipu cp4=new caipu(4, "莴笋萝卜豆腐丁", "备豆腐丁和辣椒\n再切点莴笋丁，红萝卜丁，蒿笋片，咖喱少许\n先煎豆腐，撒盐入味\n煎片刻\n煎香\n另起锅，放进莴笋，蒿笋，红萝卜丁\n放进辣椒提辣，撒盐入味\n倒进煎好的豆腐丁\n炒匀\n放进咖喱\n放清水\n煮二分钟\n撒上味精或鸡精\n再次烧开\n即成");
		cp[4]=cp4;

		
		caipu cp5=new caipu(5, "蒜炒鸡蛋","小根蒜洗净切段\n打入鸡蛋\n加入盐搅拌均匀\n锅里加入油热后，倒入小根蒜蛋液翻炒\n如果炒的太干，可沿着锅边淋入一点点水炒熟。加入盐调味");
		cp[5]=cp5;
		
		caipu cp6=new caipu(6, "糖醋鱼","黄花鱼洗净改刀，下料酒、葱姜、少许盐。腌制十来分钟。洋葱切丝，红尖椒切丝\n腌制好的鱼放入碗中鸡蛋地瓜粉打荷一起抹裹均匀\n锅烧热下油烧至78成热，将鱼放入炸至金黄色表皮酥捞出。沥油放人盘中\n锅中留油下洋葱爆炒下继续下番茄沙司炒一下，下少许清水下白糖、少许盐烧开关小火用生粉水勾芡一下在下陈醋搅拌，。把红烧汁淋到鱼身，放入香菜红尖椒丝装饰\n完成");
		cp[6]=cp6;
		
		caipu cp7=new caipu(7, "豆腐烧肉", "备豆腐和咖喱，辣椒\n豆腐切丁，辣椒切丁\n煎好的米粉肉\n先煎豆腐丁\n撒盐煎香\n放进米粉肉\n放进尖椒提辣\n倒进清水\n放进咖喱\n煮二分钟\n撒上鸡精或味精\n有香葱撒上香葱\n即成");
		cp[7]=cp7;
		
		caipu cp8=new caipu(8, "蒸茄子","备茄子，蒜，米椒\n切丁\n切好的茄丁用清水去涩味，不清也行\n沥水，装碗里\n放进蒸锅\n隔水蒸熟\n蒸好的茄子\n碗里放上切好的蒜，米椒，淋上生抽，撒上盐，淋上芝麻油，蚝油\n撒上鸡精，淋上辣椒油合成汁\n倒在蒸好的茄子上\n拌匀上桌");
		cp[8]=cp8;
		
		caipu cp9=new caipu(9, "豆腐茄子煲","根据人数准备好适量的蔬菜\n切好\n清水煮一下菜豌豆（目的：熟的快，口感软）\n加入4小匙淀粉，把茄子拌匀。干拌不加水\n把拌匀淀粉的茄子放入锅里油炸。（炸至茄子皮变色，时间约1~2分钟）捞起备用\n把豆腐放入油锅里炸，炸至外皮有点黄就捞起（注意：时间不要过长，以免炸老）豆腐选用老豆腐，不需要裹淀粉\n沥干油，装盘备用\n汤匙油，先放入姜丝之后把1汤匙老酱加入翻炒放入大辣子和菜豌豆翻炒\n加入茄子、豆腐翻炒\n加入料酒2汤匙\n白糖2小匙\n酱油2.5汤匙，素味精少许，拌匀可以起锅了");
		cp[9]=cp9;
		
		caipu cp10=new caipu(10, "辣椒炒豆腐", "食材：尖椒（已清洗切开）、油豆腐\n在锅中加入3汤勺油烧热，下入油豆腐翻炒一下\n接着，加适量的清水\n接着，加适量的清水\n加0.5汤勺白糖\n加1勺盐\n调味煮\n然后，煮至汤汁差不多时，合入切好的尖椒翻炒翻炒至熟\n最后，加0.5勺味精\n调味炒匀，即成。");
		cp[10]=cp10;
		caipu cp13=new caipu(13, "苏泊尔·中华炽陶咸肉花生粥", "准备所需材料大米洗净，切两片姜一起放入苏泊尔电炖锅内\n加入清洗干净的花生米\n再加入腌好的咸猪肉\n然后加入清水\n在控制面板上的菜单选择“砂锅粥”，默认为2个半小时，然后按下开始键\n 时间结束后，会听到“滴滴滴”的提示音，转入保温状态，这时粥已经好了，加入1小勺盐调\n,最后把盐拌至溶化即可食用\n");
		cp[13]=cp13;
		img[1]=R.drawable.t01;
		img[2]=R.drawable.t02;
		img[3]=R.drawable.t03;
		img[4]=R.drawable.t04;
		img[5]=R.drawable.t05;
		img[6]=R.drawable.t06;
		img[7]=R.drawable.t07;
		img[8]=R.drawable.t08;
		img[9]=R.drawable.t09;
		img[10]=R.drawable.t10;
		img[11]=R.drawable.t11;
		img[12]=R.drawable.t12;
		img[13]=R.drawable.t13;
		img[14]=R.drawable.t14;
		img[15]=R.drawable.t15;
		img[16]=R.drawable.t16;
		img[17]=R.drawable.t17;
		img[18]=R.drawable.t18;
		img[19]=R.drawable.t19;
		img[20]=R.drawable.t20;
	}

	public HashSet<Integer> query(int[] shicaiID) {
		result.clear();

		// for (int i = 0; i < shicaiID.length; i++)
		// for (int j = 0; j < sc[shicaiID[i]].getRelation().length; j++) {
		// result.add(sc[shicaiID[i]].getRelation()[j]);
		// }
		// return result;
		int r[] = sc[shicaiID[0]].getRelation();
		for (int i = 0; i < r.length; i++) {
			boolean flag1 = true;
			for (int j = 1; j < shicaiID.length; j++) {
				boolean flag2 = false;
				for (int k = 0; k < sc[shicaiID[j]].getRelation().length; k++)
					if (r[i] == sc[shicaiID[j]].getRelation()[k]) {
						flag2 = true;
						break;
					}	
				if (flag2 == true)
					continue;
				else {
					flag1 =false;
					break;
				}
			}
			if (flag1) {
				result.add(r[i]);
			}
		}
		return result;
	}
}
