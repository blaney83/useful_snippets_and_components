		
        m_dataPointColors = new Color[numColors];

        int[] colorVals = new int[] { 246, 0, 0, 246, 246, 0, 246, 123, 0, 246, 123, 123, 123, 123, 0, 246, 164, 82, 164, 82, 0 };
		int firstCount = 0;
		int secondCount = 1;
		int thirdCount = 2;
		int masterCount = 0;
		double shader = .3;
		float opacity = (float) .6;

		for (int i = 0; i < numColors; i++) {
			if (i > 0 && i % 3 == 0) {
				masterCount += 3;
			}
			if ((i + 1) % 21 == 0) {
				masterCount = 0;
				shader += (1 - shader) / 2;
			}
			m_dataPointColors[i] = new Color((int) Math.round((colorVals[firstCount % 3 + masterCount] * shader)),
					(int) Math.round((colorVals[secondCount % 3 + masterCount] * shader)),
					(int) Math.round((colorVals[thirdCount % 3 + masterCount] * shader)), opacity);

			firstCount++;
			secondCount++;
			thirdCount++;
		}