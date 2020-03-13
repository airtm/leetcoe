package myTest;

//提莫攻击
class Solution14 {

	public static void main(String[] args) {

		int[] timeSeries = {1,2,3,4,5,8,19};
		int time = findPoisonedDuration(timeSeries, 5);
		System.err.println(time);

	}

	public static int findPoisonedDuration(int[] timeSeries, int duration) {
		int time = 0;
		for (int i = 0; i < timeSeries.length; i++) {
			int arr = timeSeries[i];
			if(timeSeries.length == i+1) {
				time += duration;
				return time;
			}
			int next = timeSeries[i+1];
			if( next - arr >= duration ) {
				time += duration;
			}else {
				while( next - arr <  duration) {
					i++;
					if(timeSeries.length == i+1) {
						time += (next - arr);
						time += duration;
						return time;
					}
					next = timeSeries[i+1];
					if(next-arr>=duration) {
						time += (timeSeries[i] - arr);
						i--;
					}
				}
			}
		}
		return time;
	}

}