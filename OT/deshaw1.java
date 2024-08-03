class deshaw1
{
	public static void main(String[] args) {
		int e=4, k=6;
		e=k-3;
		while(e>=0)
		{
			if(k>e)
				e+=k;
			else
				k*=2;
			e=e-1;
		}
		System.out.println(k+e);
	}
}