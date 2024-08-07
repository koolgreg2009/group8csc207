package view;

import java.awt.*;
import java.awt.event.ActionEvent;

import dto.PetDTO;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * // isadd is for whether this is add or remove bookmark panel
 */
public class PetListingPanel extends javax.swing.JPanel {
	private PetActionView petActionView;
	private PetDTO pet;
    private boolean isAdd;

	public PetListingPanel(PetActionView petActionView, PetDTO pet, boolean isAdd) {
		initComponents(isAdd);
//		this.setPreferredSize(new Dimension(50, 50));
		this.petActionView = petActionView;
		this.pet = pet;
		loadData();
        this.setBorder(new EmptyBorder(20, 20, 20, 20));
        this.setBorder(new LineBorder(Color.white, 10));
	}

	private void loadData() {
		jLabel1.setText("Name: " + this.pet.getName());
		jLabel2.setText("Pet ID: " + this.pet.getPetID());
		jLabel3.setText("Age: " + pet.getPetAge());
		jLabel4.setText("Breed: " + pet.getBreed());
		jLabel5.setText("Species: " + pet.getSpecies());
		jLabel6.setText("Gender: " + pet.getGender());
	}

	@SuppressWarnings("unchecked")
    private void initComponents(boolean isAdd) {
        adoptButton = new javax.swing.JButton();
        bookmarkButton = new javax.swing.JButton();
        moreInfoButton = new javax.swing.JButton();
        adoptButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bookmarkButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        moreInfoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
		jLabel1.setText("Name: ");
		jLabel2.setText("Pet ID: ");
		jLabel3.setText("Age: ");
		jLabel4.setText("Breed: ");
		jLabel5.setText("Species: ");
		jLabel6.setText("Gender: ");

        setBackground(new java.awt.Color(223, 241, 249));

        adoptButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        adoptButton.setText("Adopt");
        adoptButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(103, 153, 242), new java.awt.Color(163, 205, 243)));
        adoptButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                onAdopt(evt);
            }
        });

        bookmarkButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        bookmarkButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(103, 153, 242), new java.awt.Color(163, 205, 243)));
        if (isAdd) {
            bookmarkButton.setText("Add Bookmark");
            bookmarkButton.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    onAdd(evt);
                }
            });
        } else{
            bookmarkButton.setText("Remove Bookmark");
            bookmarkButton.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    onRemove(evt);
                }
            });
        }
        moreInfoButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        moreInfoButton.setText("More Information");
        moreInfoButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(103, 153, 242), new java.awt.Color(163, 205, 243)));
        moreInfoButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                onMoreInfo(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
 
        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
 
        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel2)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, true)
                                        .addComponent(moreInfoButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(bookmarkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(adoptButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(3, 3, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[]{jLabel1, jLabel4, jLabel5, jLabel6});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[]{adoptButton, bookmarkButton});

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(5, 128, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(moreInfoButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(adoptButton)
                                        .addComponent(bookmarkButton)))
        );
    }// </editor-fold>
	private void onAdopt(ActionEvent evt) {
		this.petActionView.adopt(this.pet.getPetID());
	}

	private void onAdd(java.awt.event.ActionEvent evt) {
		this.petActionView.add(this.pet.getPetID());
	}

	private void onMoreInfo(java.awt.event.ActionEvent evt) {
		this.petActionView.goDetail(this.pet.getPetID());
	}

    private void onRemove(java.awt.event.ActionEvent evt) {
        this.petActionView.remove(this.pet.getPetID());
    }

	private javax.swing.JButton adoptButton;
	private javax.swing.JButton bookmarkButton;
	private javax.swing.JButton moreInfoButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
}