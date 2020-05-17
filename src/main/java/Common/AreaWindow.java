/*
 Icons downloaded from https://www.flaticon.com
 Authors are Freepik, Good Ware, Pixel perfect, monkik
 */

package Common;

import Competitors.ICompetitor;
import Obstacles.IBarrier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AreaWindow extends JFrame  {
    Timer mTimer;
    int currentBarrier = 0;

    public AreaWindow(final ICompetitor[] competitors, final IBarrier[] barriers) {
        setTitle("Olympic competition");
        setBounds(0, 0, 1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        GridBagLayout table = new GridBagLayout();

        JPanel commonPanel = new JPanel();
        commonPanel.setLayout(table);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 5;
        constraints.weighty = 5;

        JLabel[] competitorLabel = new JLabel[competitors.length];
        final JLabel[][] barrierLabel = new JLabel[competitors.length][barriers.length];
        final JButton startButton = new JButton("Начать соревнование");
        final JLabel[] captionLabel = new JLabel[barriers.length];
        constraints.gridy = 0;
        constraints.gridx = 0;
        commonPanel.add(startButton, constraints);

        for (int i = 0; i < competitors.length; i++){
            competitorLabel[i] = new JLabel(competitors[i].getPicture());
            competitorLabel[i].setText(competitors[i].getName());
            competitorLabel[i].setHorizontalTextPosition(JLabel.CENTER);
            competitorLabel[i].setVerticalTextPosition(JLabel.TOP);
            constraints.gridy = i + 1;
            constraints.gridx = 0;
            commonPanel.add(competitorLabel[i], constraints);
        }

        for (int col = 0; col < barriers.length; col++) {
            constraints.gridy = 0;
            constraints.gridx = col + 1;
            constraints.fill = GridBagConstraints.HORIZONTAL;
            captionLabel[col] = new JLabel("");
            captionLabel[col].setHorizontalTextPosition(JLabel.CENTER);
            captionLabel[col].setVerticalTextPosition(JLabel.CENTER);
            commonPanel.add(captionLabel[col], constraints);
            for (int row = 0; row < competitors.length; row++) {
                barrierLabel[row][col] = new JLabel(barriers[col].getPicture());
                barrierLabel[row][col].setHorizontalTextPosition(JLabel.CENTER);
                barrierLabel[row][col].setVerticalTextPosition(JLabel.TOP);
                barrierLabel[row][col].setOpaque(true);
                constraints.gridy = row + 1;
                constraints.gridx = col + 1;
                commonPanel.add(barrierLabel[row][col], constraints);
            }
        }
        add(commonPanel);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if (mTimer != null) {
                    mTimer.stop();
                }
                currentBarrier = 0;
                startButton.setEnabled(false);
                for (ICompetitor competitor : competitors) {
                    competitor.setReady();
                }
                for (int i = 0; i < barriers.length; i++) {
                    barriers[i].setNewHardness();
                    captionLabel[i].setText(barriers[i].getHardness());
                }

                for (int row = 0; row < competitors.length; row ++) {
                    for (int col = 0; col < barriers.length; col ++) {
                        barrierLabel[row][col].setBackground(Color.YELLOW);
                    }
                }

                mTimer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        boolean hasCompetitors = false;
                        for (int i = 0; i < competitors.length; i++){
                            boolean curResult = false;
                            if (competitors[i].isOnDistance()) {
                                curResult = barriers[currentBarrier].overcome(competitors[i]);
                            }
                            if (!curResult) {
                                for (int j = currentBarrier; j < barriers.length; j++){
                                    barrierLabel[i][j].setBackground(Color.RED);
                                }
                            } else {
                                barrierLabel[i][currentBarrier].setBackground(Color.GREEN);
                                hasCompetitors = true;
                            }
                        }
                        currentBarrier ++;
                        if (currentBarrier >= barriers.length || !hasCompetitors) {
                            mTimer.stop();
                            if (!hasCompetitors) {
                                for (int i = 0; i < competitors.length; i++) {
                                    for (int j = currentBarrier; j < barriers.length; j++) {
                                        barrierLabel[i][j].setBackground(Color.RED);
                                    }
                                }
                                JOptionPane.showMessageDialog(null, "Nobody wins");
                            } else {
                                String winners = "";
                                for (ICompetitor competitor : competitors) {
                                    if (competitor.isOnDistance()) {
                                        if (!winners.equals("")) {
                                            winners = winners.concat(", ");
                                        }
                                        winners = winners.concat(competitor.getName());
                                    }
                                }
                                JOptionPane.showMessageDialog(null, "Winners are " + winners);
                            }
                            startButton.setEnabled(true);
                        }
                    }
                });
                mTimer.start();
            }
        });

        setVisible(true);
    }
}
