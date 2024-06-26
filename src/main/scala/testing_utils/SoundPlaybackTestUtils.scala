package sesame.utils

import java.io._
import javax.sound.sampled._
import cats.effect.IO
import sesame.audio.AudioCommons.InputFormat

object SoundPlayback:

  def playWavByteArray(inputData: Array[Byte]): IO[Unit] =
    IO {
      val clip = AudioSystem.getClip()
      val byteArrayInputStream = new ByteArrayInputStream(inputData)
      val audioInputStream = AudioInputStream(byteArrayInputStream, InputFormat, inputData.size)
      clip.open(AudioSystem.getAudioInputStream(InputFormat, audioInputStream))
      clip.start()
    }
