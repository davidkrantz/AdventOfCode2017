'use strict'
let fs = require('fs');

fs.readFile('input.txt', 'utf8', (err, lines) => {
	if (err) return;
	let min, max, sum1 = 0, sum2 = 0;
	const numbers = lines.split("\n");
	numbers.forEach(line => {
		max = 0;
		min = 99999999;
		line.split("\t").forEach((x, indexX, arr) => {
			if (x > max) max = parseInt(x);
			if (x < min) min = parseInt(x);
			arr.forEach((y, indexY) => {
				if ((x % y) == 0 && indexX != indexY) {
					sum2 += x/y;
				}
			});
		});
		sum1 += (max - min);
	});
	console.log(sum1, sum2);
});