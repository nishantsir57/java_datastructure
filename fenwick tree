class BIT
{
    private int bit[];
    BIT(int a[])
    {
        bit=new int[a.length+1];
        for(int i=0;i<a.length;i++)
        update(i, a[i]);
    }
    public void update(int index, int delta)
    {
        index++;
        while(index<bit.length)
        {
            bit[index]+=delta;
            index+=index & (-index);
        }
    }
    public int query(int l, int r)
    {
        return sum(r)-sum(l);
    }
    private int sum(int i)
    {
        int sum=0;
        while(i != 0)
        {
            sum+=bit[i];
            i-= i&(-i);
        }
        return sum;
    }
    public String toString()
    {
       return (Arrays.toString(bit));
    }
}
