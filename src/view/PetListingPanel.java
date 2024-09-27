package view;

import java.awt.*;
import java.awt.event.ActionEvent;

import dto.PetDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * {@code PetListingPanel} is a JPanel that displays information about a specific pet.
 * It provides buttons for adopting the pet, adding or removing bookmarks, and viewing more information.
 * This panel also displays various pet attributes including name, age, breed, species, and gender.
 */
public class PetListingPanel extends javax.swing.JPanel {
	private PetActionView petActionView;
    private BookmarkView bookmarkView;
	private PetDTO pet;
    private boolean isAdd;

    private javax.swing.JButton adoptButton;
    private javax.swing.JButton bookmarkButton;
    private javax.swing.JButton moreInfoButton;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelAge;
    private javax.swing.JLabel jLabelBreed;
    private javax.swing.JLabel jLabelSpecies;
    private javax.swing.JLabel jLabelGender;

    /**
     * Constructs a {@code PetListingPanel} instance with the given parameters.
     *
     * @param petActionView the {@code PetActionView} instance that handles actions related to pets.
     * @param pet the {@code PetDTO} instance representing the pet to be displayed.
     * @param isAdd a boolean indicating whether the panel should display an "Add Bookmark" button (true)
     *              or a "Remove Bookmark" button (false).
     */
	public PetListingPanel(PetActionView petActionView, PetDTO pet, boolean isAdd) {
		initComponents(isAdd);
		this.petActionView = petActionView;
		this.pet = pet;
		loadData();
        this.setBorder(new EmptyBorder(20, 20, 20, 20));
        this.setBorder(new LineBorder(Color.white, 10));
	}

    /**
     * Loads the pet data into the UI components of the panel.
     * This method sets the text of the labels to display the pet's name, age, breed, species, and gender.
     */
	private void loadData() {
		jLabelName.setText("Name: " + this.pet.getName());
        jLabelAge.setText("Age: " + pet.getPetAge()+" year(s) old");
		jLabelBreed.setText("Breed: " + pet.getBreed());
		jLabelSpecies.setText("Species: " + pet.getSpecies());
		jLabelGender.setText("Gender: " + pet.getGender());
	}

    /**
     * Initializes the UI components and layout of the {@code PetListingPanel}.
     * Configures buttons for adopting, bookmarking, and viewing more information about the pet.
     *
     * @param isAdd a boolean indicating whether to display the "Add Bookmark" or "Remove Bookmark" button.
     */
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

        adoptButton.setFont(new java.awt.Font("Calibri", 1, 14));
        adoptButton.setText("Adopt");
        adoptButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED,
                null, null, new java.awt.Color(103, 153, 242),
                new java.awt.Color(163, 205, 243)));
        adoptButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                onAdopt(evt);
            }
        });

        bookmarkButton.setFont(new java.awt.Font("Calibri", 1, 14));
        bookmarkButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED,
                null, null, new java.awt.Color(103, 153, 242),
                new java.awt.Color(163, 205, 243)));
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
        moreInfoButton.setFont(new java.awt.Font("Calibri", 1, 14));
        moreInfoButton.setText("More Information");
        moreInfoButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED,
                null, null, new java.awt.Color(103, 153, 242),
                new java.awt.Color(163, 205, 243)));
        moreInfoButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                onMoreInfo(evt);
            }
        });

        jLabelName.setFont(new java.awt.Font("Calibri", 0, 14));

        jLabelAge.setFont(new java.awt.Font("Calibri", 0, 14));

        jLabelBreed.setFont(new java.awt.Font("Calibri", 0, 14));

        jLabelSpecies.setFont(new java.awt.Font("Calibri", 0, 14));

        jLabelGender.setFont(new java.awt.Font("Calibri", 0, 14));


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
                                        .addComponent(moreInfoButton, javax.swing.GroupLayout.Alignment.LEADING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, 233, 233)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(bookmarkButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(adoptButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(3, 3, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[]{jLabelName, jLabelBreed,
                jLabelSpecies, jLabelGender});

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
    }

    /**
     * Handles the action event when the adopt button is clicked.
     * This method triggers the {@code PetActionView} to adopt the pet.
     *
     * @param evt the action event triggered by clicking the adopt button.
     */
	private void onAdopt(ActionEvent evt) {
		this.petActionView.adopt(this.pet.getPetID());
	}

    /**
     * Handles the action event when the add bookmark button is clicked.
     * This method triggers the {@code PetActionView} to add the pet to bookmarks.
     *
     * @param evt the action event triggered by clicking the add bookmark button.
     */
	private void onAdd(java.awt.event.ActionEvent evt) {
		this.petActionView.add(this.pet.getPetID());
	}

    /**
     * Handles the action event when the "More Information" button is clicked.
     * This method triggers the {@code PetActionView} to display detailed information about the pet.
     *
     * @param evt the action event triggered by clicking the "More Information" button.
     */
	private void onMoreInfo(java.awt.event.ActionEvent evt) {
		this.petActionView.goDetail(this.pet.getPetID());
	}

    /**
     * Handles the action event when the "Remove Bookmark" button is clicked.
     * This method triggers the {@code PetActionView} to remove the pet from the user's bookmarks.
     *
     * @param evt the action event triggered by clicking the "Remove Bookmark" button.
     */
    private void onRemove(java.awt.event.ActionEvent evt) {
        this.petActionView.remove(this.pet.getPetID());
    }

}