package config

import com.typesafe.config.ConfigFactory
import org.slf4j.LoggerFactory

object Settings {

  private val config = ConfigFactory.load()
  private val weblogGen = config.getConfig("clickstream")
  private val logger = LoggerFactory.getLogger(getClass)
  logger.info(s"==== properties being read from file ===")

  lazy val records = weblogGen.getInt("records")
  lazy val timeMultiplier = weblogGen.getInt("time_multiplier")
  lazy val pages = weblogGen.getInt("pages")
  lazy val visitors = weblogGen.getInt("visitors")
  lazy val filePath = weblogGen.getString("file_path")

}
