import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField text_key;
	private BufferedImage img;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		img = null;
		setFont(new Font("Arial", Font.PLAIN, 15));
		setTitle("Gi\u00E2\u0301u tin trong a\u0309nh tr\u00EAn sai ph\u00E2n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 902, 725);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 888, 50);
		contentPane.add(menuBar);
		menuBar.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		JMenu mnMaHoa = new JMenu("Ma\u0303 ho\u0301a");
		
		mnMaHoa.setFont(new Font("Verdana", Font.PLAIN, 14));
		menuBar.add(mnMaHoa);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		
		mnMaHoa.add(mntmNewMenuItem);
		
		JMenu menu_decryption = new JMenu("Gia\u0309i ma\u0303");
		menu_decryption.setFont(new Font("Verdana", Font.PLAIN, 14));
		menuBar.add(menu_decryption);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 23, 888, 665);
		contentPane.add(tabbedPane);
		
		JPanel panel_encrypt = new JPanel();
		tabbedPane.addTab("New tab", null, panel_encrypt, null);
		panel_encrypt.setLayout(null);
		
		JPanel panel_text = new JPanel();
		panel_text.setBounds(41, 10, 812, 274);
		panel_encrypt.add(panel_text);
		panel_text.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Th\u00F4ng \u0111i\u00EA\u0323p :");
		lblNewLabel.setBounds(10, 10, 90, 57);
		panel_text.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblKey = new JLabel("Kho\u0301a :");
		lblKey.setBounds(10, 92, 90, 57);
		panel_text.add(lblKey);
		lblKey.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblBanMa = new JLabel("Ba\u0309n ma\u0303:");
		lblBanMa.setBounds(10, 184, 90, 57);
		panel_text.add(lblBanMa);
		lblBanMa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JTextArea text_message = new JTextArea();
		text_message.setBounds(109, 10, 569, 57);
		
		JScrollPane sp = new JScrollPane(text_message); 
		sp.setBounds(109, 10, 569, 57);
		text_message.setWrapStyleWord(true);
		//panel_text.add(text_message);
		panel_text.add(sp);
		text_key = new JTextField();
		text_key.setBounds(110, 105, 381, 36);
		panel_text.add(text_key);
		text_key.setColumns(10);
		
		JTextArea text_ciphertext = new JTextArea();
		text_ciphertext.setBounds(110, 184, 569, 57);
		panel_text.add(text_ciphertext);
		
		JButton btn_encrypt = new JButton("Ma\u0303 ho\u0301a");
		btn_encrypt.setBounds(538, 104, 85, 36);
		panel_text.add(btn_encrypt);
		
		JPanel panel_image = new JPanel();
		panel_image.setBounds(41, 294, 812, 309);
		panel_encrypt.add(panel_image);
		panel_image.setLayout(null);
		
		JButton btn_open = new JButton("M\u01A1\u0309 a\u0309nh");
		
		btn_open.setBounds(133, 10, 85, 36);
		panel_image.add(btn_open);
		
		JButton btn_embedded = new JButton("Nhu\u0301ng tin");
		
		btn_embedded.setBounds(362, 169, 94, 36);
		panel_image.add(btn_embedded);
		
		JButton btn_save = new JButton("L\u01B0u a\u0309nh");
		btn_save.setBounds(593, 10, 85, 36);
		panel_image.add(btn_save);
		
		JLabel in_image = new JLabel("");
		in_image.setBounds(27, 71, 298, 212);
		in_image.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel_image.add(in_image);
		
		JLabel out_image = new JLabel("");
		out_image.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		out_image.setBounds(497, 71, 289, 212);
		panel_image.add(out_image);
		
		JPanel panel_decrypt = new JPanel();
		tabbedPane.addTab("New tab", null, panel_decrypt, null);
		
	
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		
		btn_open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				img = null;
				JFileChooser fc = new JFileChooser("E:\\Images");
				
				FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Hình ảnh", "png","jpg");
				fc.setFileFilter(imageFilter);
				fc.setMultiSelectionEnabled(false);
				int check = fc.showDialog(btn_open, "Open");
				if(check == JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					try {
						img = ImageIO.read(f);
						Image dimg = img.getScaledInstance(in_image.getWidth()	,in_image.getHeight(), Image.SCALE_SMOOTH);
						ImageIcon icon = new ImageIcon(dimg);
						in_image.setIcon(icon);
					}
					catch (Exception ex) {
						// TODO: handle exception
					}
					
				}
				
			}
		});
		btn_embedded.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedImage gr = new BufferedImage(img.getWidth(), img.getHeight() , BufferedImage.TYPE_INT_ARGB);
					for(int i=0;i<img.getHeight();i++){
						for(int j=0;j<img.getWidth();j++) {
							Color c = new Color(img.getRGB(j, i));
							int p = c.getRed();
							
							
							Color gcolor = new Color(p,p,p,c.getAlpha());
							gr.setRGB(j,i,gcolor.getRGB());
							System.out.println(gcolor.getRGB());
						}
				
				}
					Image dimg = gr.getScaledInstance(out_image.getWidth()	,out_image.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon icon = new ImageIcon(dimg);
					out_image.setIcon(icon);
					
				}
				catch (Exception ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}
				
			}
		});
	}
}
