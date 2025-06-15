package codes;

public class Max_consecutive_ones {
	public static void main(String args[]) {
		int nums[]= {};
		int k=5;
		int one=0;
		int count=k;
		int window=0;
		int result=0;
		int l=nums.length;
		int start=0;
		for(int i=0;i<l;i++) {
			if(nums[i]==0) {
				if(count==0 && one!=0) {
					result=Math.max(result, window);
                    //System.out.println(result);
                    if(nums[i-window]==0){
                        window-=1;
                        count+=1;
                    }
                    else{
                        start=i-window;
                        while(start<i){
                            window-=1;
                            start+=1;
                            if(nums[start]==0)
                                break;
                            else
                                one-=1;
                        }
                        window-=1;
                        count+=1;
                    }
                    System.out.println(result +" "+window);
				}
				else if(count==0 && one==0) {
					count+=1;
					window-=1;
				}
				count-=1;
			}
			else{
				one+=1;
            }
			window+=1;
		}
        result=Math.max(result, window);
		System.out.println(result);
	}

}
