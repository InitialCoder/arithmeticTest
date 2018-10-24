package arithmetic;

import util.CommonUtil;
/**
 * 快速排序
 *    基本思想：选定分界值，将大于和小于此分界值的其他元素分别放在此分界值的左右边，依次将划分好的数据再次分界会得到最后有序的数组
 * @author wu
 *
 */
public class QuickSort {

	public void sort(int[] arr){
		
		quickSort(arr,0,arr.length-1);
	}
	public void quickSort(int[] arr,int l,int r){
		
		//小优化：小于16个元素时使用插入排序算法
		if(r-l<=15){
			CommonUtil.betterInser(arr, l, r);
			return ;
		}
			
		int p=partition(arr,l,r);
		quickSort(arr, l, p-1);
		quickSort(arr, p+1,r);
	}

	private int partition(int[] arr,int l,int r){
		//优化思路：快速排序在数据近乎有序的时候时间复杂度趋向n方级别，因为分区的时候会导致数据几乎只在一边，递归的层级变深了。
		//	 	通过随机获取参考的界限使得每次递归时左右树的平衡
		CommonUtil.swap(arr, l, (int)(Math.random()*(r-l+1))+l);
		int v=arr[l];
		int j=l;
		for(int i=l+1;i<=r;i++){
			if(arr[i]<v&&i!=j){
				CommonUtil.swap(arr, j+1, i);
				j++;
			}
		}
		CommonUtil.swap(arr, l, j);
		return j;
	}
	
	
	
	public static void main(String[] args) {
		int[] arr = CommonUtil.getRang(1,1000, 100);
		QuickSort sort=new QuickSort();
		sort.sort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
