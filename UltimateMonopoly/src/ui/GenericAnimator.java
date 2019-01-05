package ui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class GenericAnimator implements Runnable {

	private List<Animatable> elementsToAnimate;
	private long sleepTime = 50;
	private boolean animatorStopped = false;
	private JPanel animationPanel;

	public GenericAnimator(JPanel animationPanel) {
		this.animationPanel = animationPanel;
		elementsToAnimate = new ArrayList<>();
	}

	@Override
	public void run() {
		while (true) {
			try {
				synchronized (this) {
					if (animatorStopped == true) {
						wait();
					}
				}
				if (animatorStopped != true)
					Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				System.out.println("Program Interrupted");
				System.exit(0);
			}
			for (Animatable animatable : elementsToAnimate) {
				LinkedList<Animation> waitingAnimations = animatable.getWaitingAnimations();
				if (!waitingAnimations.isEmpty()) {
					Animation currentAnim = waitingAnimations.getFirst();
					currentAnim.animate();
					if (currentAnim.isFinished()) {
						waitingAnimations.removeFirst();
					}
				}
			}
			animationPanel.repaint();
		}
	}
	
	public void addAnimatable(Animatable animatable) {
		elementsToAnimate.add(animatable);
	}
	
	public boolean removeAnimatable(Animatable animatable) {
		return elementsToAnimate.remove(animatable);
	}
	
	

}
