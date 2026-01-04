package com.jdbcStudy.Study01;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class GUI extends JFrame {
    // 联系人数据模型
    private static class Contact {
        private int id;
        private String name;
        private String phone;
        private String group;
        private String email;
        private String address;

        public Contact(int id, String name, String phone, String group, String email, String address) {
            this.id = id;
            this.name = name;
            this.phone = phone;
            this.group = group;
            this.email = email;
            this.address = address;
        }

        // getter和setter方法
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getPhone() { return phone; }
        public void setPhone(String phone) { this.phone = phone; }
        public String getGroup() { return group; }
        public void setGroup(String group) { this.group = group; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getAddress() { return address; }
        public void setAddress(String address) { this.address = address; }
    }

    // 界面组件
    private JTable contactTable;
    private DefaultTableModel tableModel;
    private JPopupMenu rightClickMenu;
    private List<Contact> contactList;
    private int nextId = 4; // 下一个联系人ID

    public GUI() {
        // 初始化联系人数据
        contactList = new ArrayList<>();
        contactList.add(new Contact(1, "李明", "13800138000", "朋友", "liming@example.com", "北京市朝阳区"));
        contactList.add(new Contact(2, "张华", "13900139000", "同事", "zhanghua@example.com", "上海市浦东新区"));
        contactList.add(new Contact(3, "赵文菲", "13700137000", "家人", "zhaowenfei@example.com", "广州市天河区"));

        // 设置窗口基本属性
        setTitle("手机通讯录");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 居中显示

        // 创建主面板
        JPanel mainPanel = new JPanel(new BorderLayout());

        // ========== 顶部工具栏 ==========
        JPanel toolbarPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        toolbarPanel.setBackground(new Color(240, 240, 240));
        toolbarPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // 添加按钮
        JButton addBtn = new JButton("添加");
        addBtn.setIcon(new ImageIcon("add.png")); // 可替换为实际图标
        addBtn.addActionListener(e -> showAddContactDialog());

        JButton searchBtn = new JButton("搜索");
        searchBtn.setIcon(new ImageIcon("search.png"));
        searchBtn.addActionListener(e -> showSearchDialog());

        JButton refreshBtn = new JButton("刷新");
        refreshBtn.setIcon(new ImageIcon("refresh.png"));
        refreshBtn.addActionListener(e -> refreshTable());

        JButton groupBtn = new JButton("分组");
        groupBtn.setIcon(new ImageIcon("group.png"));
        groupBtn.addActionListener(e -> showGroupDialog());

        // 添加到工具栏
        toolbarPanel.add(addBtn);
        toolbarPanel.add(searchBtn);
        toolbarPanel.add(refreshBtn);
        toolbarPanel.add(groupBtn);

        // 添加搜索框
        JTextField searchField = new JTextField(20);
        searchField.setToolTipText("输入姓名或电话搜索");
        searchField.addActionListener(e -> searchContacts(searchField.getText()));
        toolbarPanel.add(searchField);

        mainPanel.add(toolbarPanel, BorderLayout.NORTH);

        // ========== 主体表格 ==========
        String[] columnNames = {"ID", "姓名", "电话", "分组"};
        tableModel = new DefaultTableModel(columnNames, 0);
        contactTable = new JTable(tableModel);
        
        // 设置表格样式
        contactTable.setRowHeight(30);
        contactTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        contactTable.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        contactTable.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 14));
        contactTable.getTableHeader().setBackground(new Color(230, 230, 230));

        // 添加滚动面板
        JScrollPane scrollPane = new JScrollPane(contactTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // ========== 右键菜单 ==========
        rightClickMenu = new JPopupMenu();
        
        JMenuItem viewItem = new JMenuItem("查看详情");
        viewItem.addActionListener(e -> showContactDetail());
        
        JMenuItem editItem = new JMenuItem("修改信息");
        editItem.addActionListener(e -> showEditContactDialog());
        
        JMenuItem deleteItem = new JMenuItem("删除");
        deleteItem.addActionListener(e -> deleteContact());
        
        rightClickMenu.add(viewItem);
        rightClickMenu.add(editItem);
        rightClickMenu.add(deleteItem);

        // 为表格添加右键菜单事件
        contactTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    int row = contactTable.rowAtPoint(e.getPoint());
                    if (row >= 0 && row < contactTable.getRowCount()) {
                        contactTable.setRowSelectionInterval(row, row);
                        rightClickMenu.show(contactTable, e.getX(), e.getY());
                    }
                }
            }
        });

        // 填充表格数据
        refreshTable();

        // 添加主面板到窗口
        add(mainPanel);
    }

    // 刷新表格数据
    private void refreshTable() {
        tableModel.setRowCount(0); // 清空表格
        for (Contact contact : contactList) {
            Object[] rowData = {
                contact.getId(),
                contact.getName(),
                contact.getPhone(),
                contact.getGroup()
            };
            tableModel.addRow(rowData);
        }
    }

    // 显示添加联系人对话框
    private void showAddContactDialog() {
        JDialog dialog = new JDialog(this, "添加联系人", true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField nameField = new JTextField();
        JTextField phoneField = new JTextField();
        JTextField groupField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField addressField = new JTextField();

        panel.add(new JLabel("姓名:"));
        panel.add(nameField);
        panel.add(new JLabel("电话:"));
        panel.add(phoneField);
        panel.add(new JLabel("分组:"));
        panel.add(groupField);
        panel.add(new JLabel("邮箱:"));
        panel.add(emailField);
        panel.add(new JLabel("地址:"));
        panel.add(addressField);

        JButton saveBtn = new JButton("保存");
        saveBtn.addActionListener(e -> {
            String name = nameField.getText().trim();
            String phone = phoneField.getText().trim();
            if (name.isEmpty() || phone.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "姓名和电话不能为空！", "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Contact newContact = new Contact(
                    nextId++,
                    name,
                    phone,
                    groupField.getText().trim(),
                    emailField.getText().trim(),
                    addressField.getText().trim()
            );
            contactList.add(newContact);
            refreshTable();
            dialog.dispose();
        });

        JButton cancelBtn = new JButton("取消");
        cancelBtn.addActionListener(e -> dialog.dispose());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(saveBtn);
        buttonPanel.add(cancelBtn);

        dialog.setLayout(new BorderLayout());
        dialog.add(panel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.setVisible(true);
    }

    // 显示修改联系人对话框
    private void showEditContactDialog() {
        int selectedRow = contactTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "请先选择一个联系人！", "提示", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int contactId = (int) tableModel.getValueAt(selectedRow, 0);
        Contact contact = findContactById(contactId);
        if (contact == null) return;

        JDialog dialog = new JDialog(this, "修改联系人", true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField nameField = new JTextField(contact.getName());
        JTextField phoneField = new JTextField(contact.getPhone());
        JTextField groupField = new JTextField(contact.getGroup());
        JTextField emailField = new JTextField(contact.getEmail());
        JTextField addressField = new JTextField(contact.getAddress());

        panel.add(new JLabel("姓名:"));
        panel.add(nameField);
        panel.add(new JLabel("电话:"));
        panel.add(phoneField);
        panel.add(new JLabel("分组:"));
        panel.add(groupField);
        panel.add(new JLabel("邮箱:"));
        panel.add(emailField);
        panel.add(new JLabel("地址:"));
        panel.add(addressField);

        JButton saveBtn = new JButton("保存");
        saveBtn.addActionListener(e -> {
            String name = nameField.getText().trim();
            String phone = phoneField.getText().trim();
            if (name.isEmpty() || phone.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "姓名和电话不能为空！", "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }

            contact.setName(name);
            contact.setPhone(phone);
            contact.setGroup(groupField.getText().trim());
            contact.setEmail(emailField.getText().trim());
            contact.setAddress(addressField.getText().trim());

            refreshTable();
            dialog.dispose();
        });

        JButton cancelBtn = new JButton("取消");
        cancelBtn.addActionListener(e -> dialog.dispose());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(saveBtn);
        buttonPanel.add(cancelBtn);

        dialog.setLayout(new BorderLayout());
        dialog.add(panel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.setVisible(true);
    }

    // 显示联系人详情
    private void showContactDetail() {
        int selectedRow = contactTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "请先选择一个联系人！", "提示", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int contactId = (int) tableModel.getValueAt(selectedRow, 0);
        Contact contact = findContactById(contactId);
        if (contact == null) return;

        String detail = String.format(
                "姓名: %s\n电话: %s\n分组: %s\n邮箱: %s\n地址: %s",
                contact.getName(),
                contact.getPhone(),
                contact.getGroup(),
                contact.getEmail(),
                contact.getAddress()
        );

        JOptionPane.showMessageDialog(this, detail, "联系人详情", JOptionPane.INFORMATION_MESSAGE);
    }

    // 删除联系人
    private void deleteContact() {
        int selectedRow = contactTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "请先选择一个联系人！", "提示", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int contactId = (int) tableModel.getValueAt(selectedRow, 0);
        Contact contact = findContactById(contactId);
        if (contact == null) return;

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "确定要删除联系人 " + contact.getName() + " 吗？",
                "确认删除",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            contactList.remove(contact);
            refreshTable();
        }
    }

    // 显示搜索对话框
    private void showSearchDialog() {
        String keyword = JOptionPane.showInputDialog(this, "请输入搜索关键词:", "搜索联系人", JOptionPane.QUESTION_MESSAGE);
        if (keyword != null && !keyword.trim().isEmpty()) {
            searchContacts(keyword.trim());
        }
    }

    // 搜索联系人
    private void searchContacts(String keyword) {
        List<Contact> searchResults = new ArrayList<>();
        for (Contact contact : contactList) {
            if (contact.getName().contains(keyword) || contact.getPhone().contains(keyword)) {
                searchResults.add(contact);
            }
        }

        // 显示搜索结果
        tableModel.setRowCount(0);
        for (Contact contact : searchResults) {
            Object[] rowData = {
                contact.getId(),
                contact.getName(),
                contact.getPhone(),
                contact.getGroup()
            };
            tableModel.addRow(rowData);
        }
    }

    // 显示分组管理对话框
    private void showGroupDialog() {
        JOptionPane.showMessageDialog(this, "分组管理功能开发中...", "提示", JOptionPane.INFORMATION_MESSAGE);
    }

    // 根据ID查找联系人
    private Contact findContactById(int id) {
        for (Contact contact : contactList) {
            if (contact.getId() == id) {
                return contact;
            }
        }
        return null;
    }

    // 主方法
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUI app = new GUI();
            app.setVisible(true);
        });
    }
}