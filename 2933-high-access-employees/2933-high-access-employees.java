class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> accessTimes) {
        Map<String, List<Integer>> employeeAccessMap = new HashMap<>();

        for (List<String> access : accessTimes) {
            String employee = access.get(0);
            int time = Integer.parseInt(access.get(1).substring(0, 2)) * 60 + 
                       Integer.parseInt(access.get(1).substring(2));
            employeeAccessMap.computeIfAbsent(employee, k -> new ArrayList<>()).add(time);
        }

        List<String> highAccessEmployees = new ArrayList<>();

        for (Map.Entry<String, List<Integer>> entry : employeeAccessMap.entrySet()) {
            List<Integer> accessList = entry.getValue();
            accessList.sort(Integer::compareTo);

            for (int i = 0; i < accessList.size()-2; i++) {
                int t1 = accessList.get(i);
                int t3 = accessList.get(i+2);

                if (Math.abs(t1 - t3) < 60) {
                    highAccessEmployees.add(entry.getKey());
                    break;
                }
            }
        }

        return highAccessEmployees;
    }
}