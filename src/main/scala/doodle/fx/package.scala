/*
 * Copyright 2015 noelwelsh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package doodle

package object fx {
  import javafx.scene.canvas.GraphicsContext

  type Algebra = doodle.fx.algebra.Algebra
  type Drawing[A] = doodle.algebra.generic.Finalized[GraphicsContext,A]
  type Contextualized[A] = doodle.algebra.generic.Contextualized[GraphicsContext,A]
  type Renderable[A] = doodle.algebra.generic.Renderable[A]

  implicit val fxRender = doodle.fx.algebra.Renderer

  type Image = doodle.algebra.Image[Algebra,Drawing,Unit]
  object Image {
    def apply(f: Algebra => Drawing[Unit]): Image = {
      new Image {
        def apply(implicit algebra: Algebra): Drawing[Unit] =
          f(algebra)
      }
    }
  }
}