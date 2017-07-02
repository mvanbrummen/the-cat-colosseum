import com.google.inject.AbstractModule
import service.{IVideoService, VideoService}

class Module extends AbstractModule {

  override def configure(): Unit = {
    bind(classOf[IVideoService]).to(classOf[VideoService])
  }

}
