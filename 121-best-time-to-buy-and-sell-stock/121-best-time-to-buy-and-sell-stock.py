class Solution(object):
    def maxProfit(self, arr):
        """
        :type prices: List[int]
        :rtype: int
        """
        l,r = 0,1
        maxP=0
        
        while r<len(arr):
            if arr[l]<arr[r]:
                profit = arr[r]-arr[l]
                maxP = max(maxP,profit)
            else:
                l = r
            r+=1
            
            
        return maxP
        