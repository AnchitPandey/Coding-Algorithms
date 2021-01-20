class Cashier {
    
    int n, discount;
    int counter =0;
    HashMap<Integer, Integer> mapper;
    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        mapper = new HashMap();
        for (int i =0; i< products.length;i+=1)
            mapper.put (products[i], prices[i]);
        counter =0;  
    }
    
    public double getBill(int[] product, int[] amount) {
        counter+=1;
        boolean dis = false;
        if (counter % n ==0)
            dis = true;
        double ans = 0.0;
        for (int i =0 ; i< product.length;i+=1)
            ans += amount[i] * mapper.get(product[i]);
        if (dis)
            ans -= (double)(discount * ans) / 100;
        return ans;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */
