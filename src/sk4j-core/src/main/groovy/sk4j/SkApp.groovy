package sk4j

import sk4j.input.InputReader

abstract class SkApp {

	def userHome = System.getenv("HOME")

	def sk4jHome = "${userHome}/git/sk4j.github.io"
	
	def start() {
		
	}

	abstract void run();

}
