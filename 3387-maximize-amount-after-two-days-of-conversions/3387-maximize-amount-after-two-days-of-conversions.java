class Solution {
    private Map<String, Map<String, Double>> buildGraph(List<List<String>> pairs, double[] rates) {
        
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        for (int i = 0; i < pairs.size(); ++i) {
            
            String startCurrency = pairs.get(i).get(0);
            String tarCurrency = pairs.get(i).get(1);
            
            double rate = rates[i];
            
            graph.putIfAbsent(startCurrency, new HashMap<>());
            graph.putIfAbsent(tarCurrency, new HashMap<>());
            graph.get(startCurrency).put(tarCurrency, rate);
            graph.get(tarCurrency).put(startCurrency, (1.0 / rate));
        }
        
        return graph;
    }

    private Map<String, Map<String, Double>> f(Map<String, Map<String, Double>> graph) {
        
        List<String> currencies = new ArrayList<>(graph.keySet());
        Map<String, Map<String, Double>> dist = new HashMap<>();

        for (String startCurrency : currencies) {
            
            dist.put(startCurrency, new HashMap<>());
            
            for (String tarCurrency : currencies) {
                
                if (startCurrency.equals(tarCurrency)) {
                    dist.get(startCurrency).put(tarCurrency, 1.0);
                } else if (graph.get(startCurrency).containsKey(tarCurrency)) {
                    dist.get(startCurrency).put(tarCurrency, graph.get(startCurrency).get(tarCurrency));
                } else {
                    dist.get(startCurrency).put(tarCurrency, 0.0);
                }
            }
        }

        for (String k : currencies) {
            for (String i : currencies) {
                for (String j : currencies) {
                    
                    double newRate = dist.get(i).get(k) * dist.get(k).get(j);
                    dist.get(i).put(j, Math.max(dist.get(i).get(j), newRate));
                }
            }
        }

        return dist;
    }

    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        
        Map<String, Map<String, Double>> graph1 = buildGraph(pairs1, rates1);
        Map<String, Map<String, Double>> graph2 = buildGraph(pairs2, rates2);
        Map<String, Map<String, Double>> day1Rates = f(graph1);
        Map<String, Map<String, Double>> day2Rates = f(graph2);

        Map<String, Double> day1hm = new HashMap<>();
        for (String currency : day1Rates.keySet()) {
            if (day1Rates.get(initialCurrency).containsKey(currency)) {
                day1hm.put(currency, day1Rates.get(initialCurrency).get(currency));
            }
        }
        day1hm.put(initialCurrency, 1.0);

        double max = 1.0;
        for (String currency : day1hm.keySet()) {
            
            double amount = day1hm.get(currency);
            
            if (day2Rates.containsKey(currency) && day2Rates.get(currency).containsKey(initialCurrency)) {
                max = Math.max(max, amount * day2Rates.get(currency).get(initialCurrency));
            }
        }

        return max;
    }
}