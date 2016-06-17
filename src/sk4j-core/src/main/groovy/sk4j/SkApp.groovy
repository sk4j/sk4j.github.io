package sk4j

import sk4j.input.InputReader

abstract class SkApp {
	
	def context = [:]

	def userHome = System.getenv("HOME")

	def sk4jHome = "${userHome}/git/sk4j.github.io"
	
	def start(args) {
		
	}

	abstract void run();

}
