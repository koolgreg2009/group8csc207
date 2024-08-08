package view;

import java.awt.*;
import java.awt.event.ActionEvent;

import dto.PetDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * // isadd is for whether this is add or remove bookmark panel
 */
public class PetListingPanel extends javax.swing.JPanel {
	private PetActionView petActionView;
    private BookmarkView bookmarkView;
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
		jLabelName.setText("Name: " + this.pet.getName());
        jLabelAge.setText("Age: " + pet.getPetAge()+" year(s) old");
		jLabelBreed.setText("Breed: " + pet.getBreed());
		jLabelSpecies.setText("Species: " + pet.getSpecies());
		jLabelGender.setText("Gender: " + pet.getGender());
	}

	@SuppressWarnings("unchecked")
    private void initComponents(boolean isAdd) {
        adoptButton = new javax.swing.JButton();
        bookmarkButton = new javax.swing.JButton();
        moreInfoButton = new javax.swing.JButton();
        adoptButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bookmarkButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        moreInfoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jLabelName = new javax.swing.JLabel();
        jLabelAge = new javax.swing.JLabel();
        jLabelBreed = new javax.swing.JLabel();
        jLabelSpecies = new javax.swing.JLabel();
        jLabelGender = new javax.swing.JLabel();
		jLabelName.setText("Name: ");
		jLabelAge.setText("Age: ");
		jLabelBreed.setText("Breed: ");
		jLabelSpecies.setText("Species: ");
		jLabelGender.setText("Gender: ");

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

        jLabelName.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabelAge.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabelBreed.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabelSpecies.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabelGender.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelBreed)
                                        .addComponent(jLabelSpecies)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelGender)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelAge))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelName)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, true)
                                        .addComponent(moreInfoButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 233, 233)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(bookmarkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(adoptButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(3, 3, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[]{jLabelName, jLabelBreed, jLabelSpecies, jLabelGender});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[]{adoptButton, bookmarkButton});

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(5, 128, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelGender)
                                        .addComponent(jLabelAge))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelSpecies)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelBreed)
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
	private javax.swing.JLabel jLabelName;
	private javax.swing.JLabel jLabelAge;
	private javax.swing.JLabel jLabelBreed;
	private javax.swing.JLabel jLabelSpecies;
	private javax.swing.JLabel jLabelGender;
}