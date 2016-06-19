package org.patchca.service;

import java.util.Random;

import org.patchca.background.SingleColorBackgroundFactory;
import org.patchca.color.ColorFactory;
import org.patchca.color.GradientColorFactory;
import org.patchca.color.MultipleColorFactory;
import org.patchca.filter.FilterFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.filter.predefined.WobbleRippleFilterFactory;
import org.patchca.font.RandomFontFactory;
import org.patchca.text.renderer.BestFitTextRenderer;
import org.patchca.word.AdaptiveRandomWordFactory;

public class CustomCaptchaService extends AbstractCaptchaService {

	private static final String wordCharacters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private AdaptiveRandomWordFactory adaptiveRandomWordFactory = new AdaptiveRandomWordFactory();

	private RandomFontFactory randomFontFactory = new RandomFontFactory();

	Random random = new Random();

	private ColorFactory randomColorFactory() {

		switch (random.nextInt(2)) {
		case 0:
			return new GradientColorFactory();
		case 1:
			return new MultipleColorFactory();
		default:
			return new MultipleColorFactory();
		}
	}

	private FilterFactory randomFilterFactory() {

		switch (random.nextInt(2)) {
		case 0:
			return new CurvesRippleFilterFactory();

		case 1:
			return new WobbleRippleFilterFactory();
		// case 2:
		// return new DiffuseRippleFilterFactory();
		// case 3:
		// return new MarbleRippleFilterFactory();
		// case 4:
		// return new DoubleRippleFilterFactory();
		default:
			return new CurvesRippleFilterFactory();
		}
	}

	public void randomColorAndFilter() {
		colorFactory = randomColorFactory();
		filterFactory = randomFilterFactory();
	}

	public void setFontSize(int minSize, int maxSize) {
		randomFontFactory.setMaxSize(maxSize);
		randomFontFactory.setMinSize(minSize);
	}

	public void setWordLength(int minLength, int maxLength) {
		adaptiveRandomWordFactory.setMinLength(minLength);
		adaptiveRandomWordFactory.setMaxLength(maxLength);
	}

	public void setImageSize(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public CustomCaptchaService() {
		randomFontFactory.setMaxSize(22);
		randomFontFactory.setMinSize(22);
		fontFactory = randomFontFactory;

		adaptiveRandomWordFactory.setCharacters(wordCharacters);
		adaptiveRandomWordFactory.setMaxLength(4);
		adaptiveRandomWordFactory.setMinLength(4);

		backgroundFactory = new SingleColorBackgroundFactory();
		wordFactory = adaptiveRandomWordFactory;

		textRenderer = new BestFitTextRenderer();
		// textRenderer.setLeftMargin(5);
		// textRenderer.setRightMargin(5);
		// textRenderer.setBottomMargin(5);
		// textRenderer.setTopMargin(5);
		colorFactory = randomColorFactory();
		filterFactory = randomFilterFactory();

		width = 75;
		height = 30;
	}
}
