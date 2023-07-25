import scala.io.StdIn.{readInt, readLine}

object CaesarCipher extends App{

  def encrypt(plainText: String, shift: Int): String = {
    plainText.map { char => //a function that takes a single character char as input
      if (char.isLetter) {
        val base = if (char.isUpper) 'A' else 'a'
        val encryptedChar = ((char - base + shift) % 26 + base).toChar
        encryptedChar
      } else {
        char
      }
    }.mkString //a method that converts a collection to a single string
  }

  def decrypt(cipherText: String, shift: Int): String = {
    encrypt(cipherText, -shift)
  }

  def cipher() {
    printf("Do you want to Encrypt(E) or Decrypt(D)?")
    val action = readLine()

    if (action == "E") {
      printf("Enter Plain Text to encrypt: ")
      val plainT = readLine()

      printf("Enter shift: ")
      val shift = readInt()

      val cipherT = encrypt(plainT, shift)
      println(s"\nEncrypted Text: $cipherT")

    }else if (action == "D"){
      printf("Enter Cipher Text to decrypt: ")
      val cipherT = readLine()

      printf("Enter shift: ")
      val shift = readInt()

      val plainT = decrypt(cipherT, shift)
      println(s"\nDecrypted Text: $plainT")
    }else
      printf("Please enter either 'E' or 'D'");
  }

  cipher()
}
