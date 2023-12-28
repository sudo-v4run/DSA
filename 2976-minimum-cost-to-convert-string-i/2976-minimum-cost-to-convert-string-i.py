from queue import PriorityQueue

class Solution:
    def minimumCost(self, source, target, original, changed, cost):
        graph = {}
        for i, elem in enumerate(original):
            if elem not in graph:
                graph[elem] = {}
            graph[elem][changed[i]] = min(cost[i], graph[elem].get(changed[i], float("inf")))

        total = 0
        memo = {} # memoizes the shortest path from source to target
        
        for i, letter in enumerate(source):
            if letter != target[i]:
                result = self.find_path(source[i], target[i], graph, memo)
                if result == -1:
                    return -1
                total += result
        return total
    
    
    def find_path(self, source, target, graph, memo):
        if (source, target) in memo:
            return memo[(source, target)]
        
        pq = PriorityQueue()
        pq.put((0, source))
        seen = set()
        
        while not pq.empty():
            cost, letter = pq.get()
            if letter == target:
                memo[(source, target)] = cost
                return cost
            if letter not in seen:
                seen.add(letter)
                memo[(source, letter)] = cost
                edges = graph.get(letter, [])
                for edge in edges:
                    pq.put((cost + edges[edge], edge))
        return -1