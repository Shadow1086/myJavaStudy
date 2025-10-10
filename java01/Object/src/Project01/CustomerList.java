package Project01;

/**
 * ClassName: Practice01
 * Package: Project01
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/2 14:56
 * {@code @Version} 1.0
 */

public class CustomerList {
    Customer[] customers;
    int total = 0;

    /**
     * 用途：构造器，用来初始化customers数组
     * 参数：totalCustomer：指定customers数组的最大空间
     *
     * @param totalCustomers 数组的最大空间
     */
    public CustomerList(int totalCustomers) {
        customers = new Customer[totalCustomers];
    }

    /**
     * 用途：将参数customer添加组中最后一个客户对象记录之后
     *
     * @param customer 指定要添加的客户对象
     * @return true(添加成功)\false(添加失败)
     */
    public boolean addCustomer(Customer customer) {
        if (total < customers.length) {
            customers[total++] = customer;
            return true;
        } else {
            return false;
        }
    }

    /**
     * 用途：用参数customer替换数组中由index指定的对象
     *
     * @param customer customer指定替换的新客户对象
     * @param index    index指定所替换对象在数组中的位置，从0开始
     * @return 替换成功返回true；false表示索引无效，无法替换
     */
    public boolean replaceCustomer(Customer customer, int index) {
        if (index < 0 || index >= total) {
            System.out.println("替换失败，索引有误");
            return false;
        } else {
            customers[index] = customer;
            return true;
        }
    }

    /**
     * 用途：从数组中删除参数index指定索引位置的客户对象记录
     *
     * @param index index指定所删除对象在数组中的索引位置，从0开始
     * @return 删除成功返回true；false表示索引无效，无法删除
     */
    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= total) {
            return false;
        }
        for (int i = index; i < total - 1; i++) {
            customers[i] = customers[i + 1];
        }
//        customers[total - 1] = null;
//        total --;
        customers[--total] = null;
        return true;
    }

    /**
     * 用途：返回数组中记录的所有客户对象
     *
     * @return Customer[] 数组中包含了当前所有客户对象，该数组长度与对象个数相同
     */
    public Customer[] getAllCustomer() {
        Customer[] custs = new Customer[total];
        for (int i = 0; i < total; i++) {
            custs[i] = customers[i];
        }
        return custs;
    }

    /**
     * 用途：返回参数index指定索引位置的客户对象记录
     *
     * @param index index指定所要获取的客户在数组中的索引位置，从0开始
     * @return 封装了客户信息的Customer对象
     */
    public Customer getCustomer(int index) {
        if (index >= 0 && index < total) {
            return customers[index];
        }
        return null;
    }

    /**
     * 获取客户列表中客户总数量
     *
     * @return total
     */
    public int getTotal() {
        return total;
    }
}