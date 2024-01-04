package utils

class DiskUnbalancedException(val expectedWeight: Int) : Exception()