'use strict'
let fs = require('fs');

fs.readFile('input.txt', 'utf8', (err, lines) => {
	if (err) return;
	let min, max, sum = 0;
	const numbers = lines.split("\n");
	numbers.forEach(line => {
		max = 0;
		min = 99999999;
		line.split("\t").forEach(x => {
			if (x > max) max = parseInt(x);
			if (x < min) min = parseInt(x);
		})
		sum += (max - min);
	});
	console.log(sum)
});