// 31. Next Permutation
class Solution {
  public int maxArea(int[] height) {
  int len=height.length;
  
  int leftArr[]=new int[len];
  int left=0;
  leftArr[left]= height[left];
  for(left=1;left<len;left++){
     leftArr[left]=Math.max(leftArr[left-1],height[left]);
  }

  int rightArr[]=new int[len];
  int right=len-1;
  rightArr[right]=height[right];
  for(right=len-2;right>=0;right--){
     rightArr[right]=Math.max(rightArr[right+1],height[right]);
  }
  
  int maxwater=0;
  left=0;
  right=len-1;
  while(left<right){
    int minval=Math.min(leftArr[left],rightArr[right]);
    int noofspace=right-left;
    maxwater=Math.max(maxwater,minval*noofspace);
    if(leftArr[left]<rightArr[right]){
        left++;
    }else{
        right--;
    }
  }
   return maxwater;
    }
}