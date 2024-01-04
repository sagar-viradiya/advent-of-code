import utils.splitAtNewLines

object Day18 {

    fun part1(input: String): Long {

        val instructions = input.splitAtNewLines()
        val registerMap = mutableMapOf<Char, Long>()
        var latestFrequency = 0L
        var i = 0L
        var instruction: Instruction
        loop@ while (i < instructions.size) {
            if (i < 0) {
                throw IllegalStateException("Freak out!!!")
            }
            instruction = decodeInstruction(instructions[i++.toInt()])
            when (instruction) {
                is Instruction.SND -> latestFrequency = registerMap[instruction.register] ?: 0
                is Instruction.RCV -> if ((registerMap[instruction.register] ?: 0) != 0L) break@loop
                is Instruction.SET -> {
                    if (instruction.value is Char) {
                        registerMap[instruction.register] = registerMap[instruction.value as Char] ?: 0
                    } else {
                        registerMap[instruction.register] = instruction.value as Long
                    }
                }
                is Instruction.ADD -> {
                    if (instruction.value is Char) {
                        registerMap[instruction.register] = (registerMap[instruction.register] ?: 0) +
                                (registerMap[instruction.value as Char] ?: 0)
                    } else {
                        registerMap[instruction.register] = (registerMap[instruction.register] ?: 0) +
                                (instruction.value as Long)
                    }
                }
                is Instruction.MUL -> {
                    if (instruction.value is Char) {
                        registerMap[instruction.register] = (registerMap[instruction.register] ?: 0) *
                                (registerMap[instruction.value as Char] ?: 0)
                    } else {
                        registerMap[instruction.register] = (registerMap[instruction.register] ?: 0) *
                                (instruction.value as Long)
                    }
                }
                is Instruction.MOD -> {
                    if (instruction.value is Char) {
                        registerMap[instruction.register] = (registerMap[instruction.register] ?: 0) %
                                (registerMap[instruction.value as Char] ?: 0)
                    } else {
                        registerMap[instruction.register] = (registerMap[instruction.register] ?: 0) %
                                (instruction.value as Long)
                    }
                }
                is Instruction.JGZ -> {
                    if (registerMap[instruction.register] ?: 0 > 0) {
                        i += if (instruction.value is Char) {
                            (registerMap[instruction.value as Char] ?: 0) - 1
                        } else {
                            (instruction.value as Long) - 1
                        }
                    }
                }
            }
        }

        return latestFrequency

    }

    private fun decodeInstruction(instruction: String): Instruction {

        return when {
            instruction.contains("snd") -> Instruction.SND(instruction[4])
            instruction.contains("rcv") -> Instruction.RCV(instruction[4])
            else -> {
                val value: Any
                val subString= instruction.substring(6)
                value = when {
                    subString.length > 1 -> subString.toLong()
                    instruction[6].toInt() in 97..122 -> instruction[6]
                    else -> instruction[6].toString().toLong()
                }
                when {
                    instruction.contains("set") -> Instruction.SET(instruction[4], value)
                    instruction.contains("add") -> Instruction.ADD(instruction[4], value)
                    instruction.contains("mul") -> Instruction.MUL(instruction[4], value)
                    instruction.contains("mod") -> Instruction.MOD(instruction[4], value)
                    instruction.contains("jgz") -> Instruction.JGZ(instruction[4], value)
                    else -> throw IllegalStateException("Invalid operation")
                }
            }
        }

    }

    sealed class Instruction {

        class SND(val register: Char) : Instruction()
        class SET(val register: Char, val value: Any) : Instruction()
        class ADD(val register: Char, val value: Any) : Instruction()
        class MUL(val register: Char, val value: Any) : Instruction()
        class MOD(val register: Char, val value: Any) : Instruction()
        class RCV(val register: Char) : Instruction()
        class JGZ(val register: Char, val value: Any) : Instruction()

    }

}