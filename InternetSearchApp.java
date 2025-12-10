import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.border.TitledBorder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.awt.*;
import java.net.URI;


/* ===========================
      MAIN APPLICATION
   =========================== */

public class InternetSearchApp extends JFrame {

    private JEditorPane txtResult;
    private JTextArea txtWeb;
    private JTextField txtTK1, txtTK2, txtTK3;

    public InternetSearchApp() {

        setTitle("🔍 InternetSearchApp - Tìm Kiếm Tin Tức & Giá Sản Phẩm");
        setSize(1200, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Tạo panel chính với BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(240, 240, 245));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ===== HEADER =====
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(41, 128, 185));
        JLabel lblTitle = new JLabel("🔍 InternetSearchApp - Tìm Kiếm Tin Tức & Giá Sản Phẩm", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setForeground(Color.WHITE);
        headerPanel.add(lblTitle);
        headerPanel.setPreferredSize(new Dimension(0, 50));
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // ===== CONTENT PANEL =====
        JPanel contentPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        contentPanel.setBackground(new Color(240, 240, 245));

        // ===== LEFT PANEL (TÌM KIẾM) =====
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)), "📋 Danh Sách RSS & Tìm Kiếm", TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.BOLD, 12)));
        leftPanel.setBorder(BorderFactory.createCompoundBorder(
            new TitledBorder(BorderFactory.createLineBorder(new Color(100, 150, 200), 2), "📋 Danh Sách RSS & Tìm Kiếm", TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.BOLD, 12)),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        JLabel lblList = new JLabel("RSS Feeds:");
        lblList.setFont(new Font("Arial", Font.BOLD, 11));
        leftPanel.add(lblList);
        leftPanel.add(Box.createVerticalStrut(5));

        txtWeb = new JTextArea();
        txtWeb.setText(
                "https://dantri.com.vn/rss/xa-hoi.rss\n" +
                "https://vnexpress.net/rss/tin-moi-nhat.rss\n" +
                "https://vietnamnet.vn/rss/thoi-su.rss\n" +
                "https://tuoitre.vn/rss/thoi-su.rss\n" +
                "https://zingnews.vn/rss/thoi-su.rss"
        );
        txtWeb.setFont(new Font("Courier New", Font.PLAIN, 10));
        JScrollPane scrollWeb = new JScrollPane(txtWeb);
        scrollWeb.setPreferredSize(new Dimension(0, 150));
        leftPanel.add(scrollWeb);
        leftPanel.add(Box.createVerticalStrut(10));

        // ===== TỪ KHÓA =====
        JLabel lblSearchTitle = new JLabel("🔎 Từ Khóa Tìm Kiếm:");
        lblSearchTitle.setFont(new Font("Arial", Font.BOLD, 11));
        leftPanel.add(lblSearchTitle);
        leftPanel.add(Box.createVerticalStrut(5));

        JLabel lblTK1 = new JLabel("Từ khóa 1:");
        lblTK1.setFont(new Font("Arial", Font.PLAIN, 10));
        txtTK1 = new JTextField();
        txtTK1.setMaximumSize(new Dimension(Integer.MAX_VALUE, 28));
        leftPanel.add(lblTK1);
        leftPanel.add(txtTK1);
        leftPanel.add(Box.createVerticalStrut(5));

        JLabel lblTK2 = new JLabel("Từ khóa 2:");
        lblTK2.setFont(new Font("Arial", Font.PLAIN, 10));
        txtTK2 = new JTextField();
        txtTK2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 28));
        leftPanel.add(lblTK2);
        leftPanel.add(txtTK2);
        leftPanel.add(Box.createVerticalStrut(5));

        JLabel lblTK3 = new JLabel("Từ khóa 3:");
        lblTK3.setFont(new Font("Arial", Font.PLAIN, 10));
        txtTK3 = new JTextField();
        txtTK3.setMaximumSize(new Dimension(Integer.MAX_VALUE, 28));
        leftPanel.add(lblTK3);
        leftPanel.add(txtTK3);
        leftPanel.add(Box.createVerticalStrut(10));

        // ===== BUTTONS =====
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));

        JButton btnSearch = new JButton("📰 Tìm Tin Tức");
        btnSearch.setFont(new Font("Arial", Font.BOLD, 12));
        btnSearch.setBackground(new Color(46, 204, 113));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFocusPainted(false);
        btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JButton btnPrice = new JButton("💰 Tìm Giá");
        btnPrice.setFont(new Font("Arial", Font.BOLD, 12));
        btnPrice.setBackground(new Color(155, 89, 182));
        btnPrice.setForeground(Color.WHITE);
        btnPrice.setFocusPainted(false);
        btnPrice.setCursor(new Cursor(Cursor.HAND_CURSOR));

        buttonPanel.add(btnSearch);
        buttonPanel.add(btnPrice);
        leftPanel.add(buttonPanel);
        leftPanel.add(Box.createVerticalGlue());

        contentPanel.add(leftPanel);

        // ===== RIGHT PANEL (KẾT QUẢ) =====
        JPanel rightPanel = new JPanel(new BorderLayout(0, 0));
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(BorderFactory.createCompoundBorder(
            new TitledBorder(BorderFactory.createLineBorder(new Color(100, 150, 200), 2), "📊 Kết Quả Tìm Kiếm", TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.BOLD, 12)),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        // ===== RESULT PANEL =====
        txtResult = new JEditorPane();
        txtResult.setEditable(false);
        txtResult.setContentType("text/html");
        txtResult.setText("<html><body style='font-family:Arial; padding: 10px;'><i>Nhập từ khóa và nhấn nút tìm kiếm...</i></body></html>");

        txtResult.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED){
                    try{
                        Desktop.getDesktop().browse(new URI(e.getURL().toString()));
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(null,"Không mở được link!");
                    }
                }
            }
        });

        JScrollPane scrollResult = new JScrollPane(txtResult);
        rightPanel.add(scrollResult, BorderLayout.CENTER);

        contentPanel.add(rightPanel);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // ===== ADD ACTION =====
        btnSearch.addActionListener(e -> searchRSS());
        btnPrice.addActionListener(e -> searchPrice());

        add(mainPanel);
    }

    private String highlight(String text, String... keywords){
        String result = text;
        for(String kw: keywords){
            if(!kw.isEmpty()){
                result = result.replaceAll("(?i)(" + kw + ")", "<span style='background-color:yellow;'>$1</span>");
            }
        }
        return result;
    }

    // ===== TÌM RSS (CHỈ THEO TIÊU ĐỀ) =====
    private void searchRSS(){

        String k1 = txtTK1.getText().trim().toLowerCase();
        String k2 = txtTK2.getText().trim().toLowerCase();
        String k3 = txtTK3.getText().trim().toLowerCase();

        txtResult.setText("<i>Đang tìm kiếm tin tức...</i>");

        new Thread(() -> {
            String[] rssLinks = txtWeb.getText().split("\n");
            StringBuilder sb = new StringBuilder();
            int count = 0;
            sb.append("<html><body style='font-family:Arial;'>");

            try{
                for(String rss: rssLinks){
                    rss = rss.trim();
                    if(rss.isEmpty()) continue;

                    Document doc = Jsoup.connect(rss)
                            .userAgent("Mozilla/5.0")
                            .timeout(10000)
                            .get();

                    for(Element item: doc.select("item")){
                        String title = item.select("title").text();
                        String link = item.select("link").text();

                        String titleLower = title.toLowerCase();

                        boolean match = false;
                        if (!k1.isEmpty() && titleLower.contains(k1)) match = true;
                        if (!k2.isEmpty() && titleLower.contains(k2)) match = true;
                        if (!k3.isEmpty() && titleLower.contains(k3)) match = true;

                        if (!match) continue;

                        count++;
                        sb.append("<p><b>")
                                .append(highlight(title, k1, k2, k3))
                                .append("</b><br>")
                                .append("<a href='").append(link).append("'>")
                                .append(link)
                                .append("</a></p><hr>");
                    }
                }
            }catch(Exception ex){
                txtResult.setText("<b>Lỗi khi đọc RSS:</b> "+ex.getMessage());
                return;
            }

            sb.append("</body></html>");
            txtResult.setText(count == 0 ? "<b>Không tìm thấy kết quả!</b>" : sb.toString());
        }).start();
    }

    // ===== TÌM GIÁ SẢN PHẨM NHIỀU TRANG TMĐT =====
    private void searchPrice() {
        String product = txtTK1.getText().trim();
        if (product.isEmpty()) {
            txtResult.setText("<b>Nhập tên sản phẩm ở Từ khóa 1 để tìm giá.</b>");
            return;
        }

        txtResult.setText("<i>Đang tìm giá sản phẩm...</i>");

        new Thread(() -> {
            StringBuilder sb = new StringBuilder();
            sb.append("<html><body style='font-family:Arial;'>");

            try {
                // Google Shopping
                String url = "https://www.google.com/search?tbm=shop&q=" + product.replace(" ", "+");
                Document doc = Jsoup.connect(url)
                        .userAgent("Mozilla/5.0")
                        .timeout(10000)
                        .get();

                int count = 0;
                for (Element item : doc.select("div.sh-dgr__content")) {
                    String name = item.select("h4").text();
                    String price = item.select("span.O8U6h").text();

                    if (!name.isEmpty() && !price.isEmpty()) {
                        sb.append("<p><b>").append(name).append("</b><br>")
                                .append("Giá: ").append(price)
                                .append("</p>");
                        count++;
                    }
                    if (count >= 5) break;
                }

                // Các link TMĐT phổ biến (BỎ Sendo)
                String encodedPlus = product.replace(" ", "+");
                String encodedPercent = product.replace(" ", "%20");

                sb.append("<hr><p>Tìm sản phẩm trên các trang thương mại điện tử:</p>");
                sb.append("<ul>");
                sb.append("<li><a href='https://shopee.vn/search?keyword=").append(encodedPercent).append("' target='_blank'>Shopee</a></li>");
                sb.append("<li><a href='https://www.lazada.vn/catalog/?q=").append(encodedPlus).append("' target='_blank'>Lazada</a></li>");
                sb.append("<li><a href='https://tiki.vn/search?q=").append(encodedPlus).append("' target='_blank'>Tiki</a></li>");
                sb.append("<li><a href='https://www.thegioididong.com/tim-kiem?key=").append(encodedPlus).append("' target='_blank'>Thế Giới Di Động</a></li>");
                sb.append("<li><a href='https://www.dienmayxanh.com/tim-kiem?key=").append(encodedPlus).append("' target='_blank'>Điện Máy Xanh</a></li>");
                sb.append("</ul>");

            } catch (Exception ex) {
                sb.append("<b>Lỗi khi tìm giá sản phẩm:</b> ").append(ex.getMessage());
            }

            sb.append("</body></html>");
            txtResult.setText(sb.toString());
        }).start();
    }

    // ===== MAIN RUN =====
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            new InternetSearchApp().setVisible(true);
        });
    }
}
