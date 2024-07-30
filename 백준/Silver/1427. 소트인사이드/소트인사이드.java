
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// 슈도코드
//		str (정렬할 수)
//		arr (자릿수별로 구분해 저장한 배열)
//		for (str의 길이만큼 반복하기) {
//			A 배열 저장 -> str.substring 사용하
//		}
//		for (i : 0 ~ str 길이만큼 반복하기) {
//			for (j : i + 1 ~ str의 길이만큼 반복하기) {
//				현재 범위에서 Max값 추가
//			}
//			현재 i의 값과 Max값 중 Max 값이 더 크면 swap 수행하
//		
//		}
//		arr 배열 출력하기
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int[] arr = new int[str.length()];
		
		for (int i = 0; i < str.length(); i++) {
			arr[i] = Integer.parseInt(str.substring(i, i+1));
		}
		
		for (int i = 0; i < str.length(); i++) {
			int max = i;
			for (int j = i + 1; j < str.length(); j++) {
				if (arr[j] > arr[max]) {
					max = j;
				}
			}
			if (arr[i] < arr[max]) {
				int temp = arr[i];
				arr[i] = arr[max];
				arr[max] = temp;
			}
		}
		for (int i = 0; i < str.length(); i++) {
			System.out.print(arr[i]);
		}
		
	}

}
