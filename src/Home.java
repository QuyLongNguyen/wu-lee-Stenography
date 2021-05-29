import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
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
import java.io.IOException;
import java.util.Base64;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField text_key;
	private BufferedImage img;
	private BufferedImage emb_img;
	private JTextField size_field;

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

		JMenu mnMaHoa = new JMenu("          ");

		mnMaHoa.setFont(new Font("Verdana", Font.PLAIN, 14));
		menuBar.add(mnMaHoa);

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

		JLabel lblKey = new JLabel("Khóa AES:");
		lblKey.setBounds(10, 92, 90, 57);
		panel_text.add(lblKey);
		lblKey.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblBanMa = new JLabel("Ba\u0309n ma\u0303:");
		lblBanMa.setBounds(10, 184, 90, 57);
		panel_text.add(lblBanMa);
		lblBanMa.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JTextArea text_message = new JTextArea();
		text_message.setFont(new Font("Monospaced", Font.PLAIN, 14));
		text_message.setBounds(109, 10, 569, 57);

		JScrollPane sp1 = new JScrollPane(text_message);
		sp1.setBounds(109, 10, 569, 57);
		text_message.setWrapStyleWord(true);
		panel_text.add(sp1);
		text_key = new JTextField();
		text_key.setFont(new Font("Tahoma", Font.PLAIN, 14));
		text_key.setBounds(110, 105, 363, 36);
		panel_text.add(text_key);
		text_key.setColumns(10);

		
		JTextArea text_cipher = new JTextArea();
		text_cipher.setFont(new Font("Monospaced", Font.PLAIN, 14));
		
		
		JScrollPane sp2 = new JScrollPane(text_cipher);
		sp2.setBounds(110, 184, 569, 57);
		text_cipher.setWrapStyleWord(true);
		panel_text.add(sp2);

		JButton btn_encrypt = new JButton("Ma\u0303 ho\u0301a");
		
		btn_encrypt.setBounds(498, 104, 85, 36);
		panel_text.add(btn_encrypt);
		
		JButton btn_decrypt = new JButton("Giải mã");
		
		btn_decrypt.setBounds(593, 104, 85, 36);
		panel_text.add(btn_decrypt);
		
		JLabel lblNewLabel_2 = new JLabel("(ít hơn 16 ký tự)");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(110, 147, 179, 13);
		panel_text.add(lblNewLabel_2);
		
		JButton btn_delete1 = new JButton("Xóa");
		
		btn_delete1.setBounds(694, 30, 57, 36);
		panel_text.add(btn_delete1);
		
		JButton btn_delete3 = new JButton("Xóa");
		btn_delete3.setBounds(694, 204, 57, 36);
		panel_text.add(btn_delete3);
		
		JButton btn_delete2 = new JButton("Xóa");
		btn_delete2.setBounds(694, 105, 57, 36);
		panel_text.add(btn_delete2);

		JPanel panel_image = new JPanel();
		panel_image.setBounds(41, 294, 812, 309);
		panel_encrypt.add(panel_image);
		panel_image.setLayout(null);

		JButton btn_open = new JButton("M\u01A1\u0309 a\u0309nh");

		btn_open.setBounds(133, 10, 85, 36);
		panel_image.add(btn_open);

		JButton btn_embedded = new JButton("Nhu\u0301ng tin");

		btn_embedded.setBounds(360, 71, 94, 36);
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
		out_image.setBounds(488, 71, 298, 212);
		panel_image.add(out_image);

		JButton btn_extract = new JButton("Tách tin");

		btn_extract.setBounds(360, 151, 94, 36);
		panel_image.add(btn_extract);
		
		size_field = new JTextField();
		size_field.setBounds(358, 235, 96, 37);
		panel_image.add(size_field);
		size_field.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Khóa tách");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(370, 197, 68, 36);
		panel_image.add(lblNewLabel_1);

		mnMaHoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btn_delete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_message.setText("");
			}
		});
		btn_delete2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_key.setText("");
			}
		});
		btn_delete3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_cipher.setText("");
			}
		});
		btn_encrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					while(text_key.getText().length() < 16) {
						text_key.setText(text_key.getText()+" ");
					}
						String originalText = text_message.getText();
						String key = text_key.getText();
						SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
						Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
						cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
						byte[] byteEncrypted = cipher.doFinal(originalText.getBytes());
						String encrypted = Base64.getEncoder().encodeToString(byteEncrypted);
						text_cipher.setText(encrypted);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
			}
		});
		btn_decrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					while(text_key.getText().length() < 16) {
						text_key.setText(text_key.getText()+" ");
					}
					String encryptText = text_cipher.getText();
					String key = text_key.getText();
					SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
					Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
					cipher.init(Cipher.DECRYPT_MODE, skeySpec);
					byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptText));
					text_message.setText(new String(decrypted));
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btn_open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				img = null;
				JFileChooser fc = new JFileChooser("E:\\Images");

				FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Hình ảnh", "png", "jpg");
				fc.setFileFilter(imageFilter);
				fc.setMultiSelectionEnabled(false);
				int check = fc.showDialog(btn_open, "Open");
				if (check == JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					try {
						img = ImageIO.read(f);
						Image dimg = img.getScaledInstance(in_image.getWidth(), in_image.getHeight(),
								Image.SCALE_SMOOTH);
						ImageIcon icon = new ImageIcon(dimg);
						in_image.setIcon(icon);
					} catch (Exception ex) {
						// TODO: handle exception
					}

				}

			}
		});
		btn_embedded.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

					emb_img = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
					Integer[][] d = new Integer[img.getHeight()][img.getWidth() / 2];
					int[] dec = MyCaculation.convertTextStringToDecArray(text_message.getText());
					String emb_string = MyCaculation.convertDecArrayToBin(dec);
					int strlen = emb_string.length();
					int string_offset = 0;
					
					for (int i = 0; i < d.length; i++) {
						for (int j = 0; j < d[0].length; j++) {
							Color c = new Color(img.getRGB(j * 2, i));
							Color c_ = new Color(img.getRGB(j * 2 + 1, i));
							int g0 = c.getRed();
							int g1 = c_.getRed();
							int g0_ = g0, g1_ = g1;

							if (string_offset < strlen) {

								d[i][j] = g1 - g0;
								int[] r = MyCaculation.inRange(Math.abs(d[i][j]));

								int n = MyCaculation.log2(r[1] - r[0] + 1);
								if (string_offset + n >= strlen) {
									n = strlen - string_offset;
								}
								String b = emb_string.substring(string_offset, string_offset + n);
								string_offset += n;
								b = MyCaculation.fixLengthOfBin(b, n);	
								int bToDec = Integer.parseInt(b, 2);

								int d_ = 0;
								if (d[i][j] >= 0) {
									d_ = r[0] + bToDec;
								} else {
									d_ = -(r[0] + bToDec);
								}

								if (d[i][j] % 2 == 0) {
									g0_ = g0 - MyCaculation.roundUp((d_ - d[i][j]) / 2);
									g1_ = g1 + MyCaculation.roundDown((d_ - d[i][j]) / 2);
								} else {
									g0_ = g0 - MyCaculation.roundDown((d_ - d[i][j]) / 2);
									g1_ = g1 + MyCaculation.roundUp((d_ - d[i][j]) / 2);
								}
							}
							Color gcolor = new Color(g0_, g0_, g0_, c.getAlpha());
							emb_img.setRGB(j * 2, i, gcolor.getRGB());
							gcolor = new Color(g1_, g1_, g1_, c_.getAlpha());
							emb_img.setRGB(j * 2 + 1, i, gcolor.getRGB());

						}

					}
					Image dimg = emb_img.getScaledInstance(out_image.getWidth(), out_image.getHeight(),
							Image.SCALE_SMOOTH);
					ImageIcon icon = new ImageIcon(dimg);
					out_image.setIcon(icon);
					JOptionPane.showMessageDialog(btn_embedded, "Giấu tin thành công");

				} catch (Exception ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}

			}
		});

		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					
					ImageIO.write(emb_img, "png",new File("E:\\long1.png"));
				}
				catch (Exception ex) {
					System.out.println("Lỗi đọc");
					// TODO: handle exception
				}
				
				
			}
		});
		btn_extract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer[][] d = new Integer[img.getHeight()][img.getWidth() / 2];
				String ext_string = "";
				int string_offset = 0;
				for (int i = 0; i < d.length; i++) {
					for (int j = 0; j < d[0].length; j++) {
						Color c = new Color(img.getRGB(j * 2, i));
						Color c_ = new Color(img.getRGB(j * 2 + 1, i));
						int g0 = c.getRed();
						int g1 = c_.getRed();
						d[i][j] = g1 - g0;
						
					
						int r[] = MyCaculation.inRange(d[i][j]);
						int n = MyCaculation.log2(r[1]-r[0]+1);
						int b = Math.abs(d[i][j])-r[0];
						String bToBin = Integer.toBinaryString(b);
						bToBin = MyCaculation.fixLengthOfBin(bToBin, n);
						ext_string += bToBin;
						
					}
					
					
				}
				text_message.setText("");
				int[] dec = MyCaculation.convertBinToDecArray(ext_string);
				text_message.setText(MyCaculation.convertDecArrayToTextString(dec));
			}
		});
	}
}
