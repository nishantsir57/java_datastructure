import java.util.*;
class SegmentTree 
{
    int segmentTree[];
    SegmentTree(int a[])
    {
        int length=a.length;
        int x=(int)Math.ceil(Math.log(length)/Math.log(2));
        int size=(int)Math.pow(2,x)-1;
        segmentTree=new int[size];
        buildSegmentTree(a, 0, size, 0);
    }
     int buildSegmentTree(int a[], int start, int end, int node)
    {
        if(start==end)
            {
                segmentTree[node]=a[start];
                return segmentTree[node];
            }
        int mid=start+(end-start)/2;
        buildSegmentTree(a, start, mid, 2*node+1);
        buildSegmentTree(a, mid+1, end, 2*node+2);
        return (int)Math.min(2*node+1, 2*node+2);
    }
    void update(int start, int end, int index, int value, int node)
    {
        if(index<start || index>end)
            return;
        if(start==index && end==index)
            {
                segmentTree[start]=value;
                return;
            }
        int mid=start+(end-start)/2;
        update(start, mid, index, value, 2*node+1);
        update(mid+1, end, index, value, 2*node+2);
        segmentTree[node]=(int)Math.min(segmentTree[2*node+1], segmentTree[2*node+2]);
    }
    int query(int start, int end, int qstart, int qend, int node)
    {
        if(qstart>end || qend<start)
            return Integer.MAX_VALUE;
        if(qstart<=start && qend>=end)
            return segmentTree[node];
        int mid=start+(end-start)/2;
        int element1=query(start, mid, qstart, qend, 2*node+1);
        int element2=query(mid+1, end, qstart, qend, 2*node+2);
            return (int)Math.min(element1, element2);
    }
}
