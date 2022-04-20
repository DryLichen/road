package string.algor;
/*
获取一个字符串在另一个字符串中出现的次数。
  比如：获取“ab”在 “abkkcadkabkebfkaabkskab” 中出现的次数
 */
public class CountTest {
	public static void main(String[] args) {
		String str1 = "abkkcadkabkebfkaabkskab";
		String str2 = "ab";
		char[] ch1 = new char[str1.length()];
		char[] ch2 = new char[str2.length()];
		int count;
		
		//提取字符串的char[]
		for(int i = 0;i < str1.length();i++) {
			ch1[i] = str1.charAt(i);
		}
		for(int i = 0;i < str2.length();i++) {
			ch2[i] = str2.charAt(i);
		}
		
		//判断是否相等并计数
		for(int i = 0;i < ch1.length;i++) {
			for(int j = 0;j < ch2.length;j++) {
				if(ch1[i] == ch2[j]) {
					if()
				}
				
			}
		}
				
	}
}
