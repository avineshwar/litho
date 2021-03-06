/**
 * Copyright (c) 2017-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */

package com.facebook.litho.widget;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.MountSpec;
import com.facebook.litho.annotations.OnCreateMountContent;
import com.facebook.litho.annotations.OnMount;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.annotations.ResType;

/**
 * A component that paints rounded edges to mimic a clipping operation on the
 * component being rendered below it. Used in {@link CardSpec}.
 *
 * @prop clippingColor Color for corner clipping.
 * @prop cornerRadius Radius for corner clipping.
 */
@MountSpec(isPureRender = true)
class CardClipSpec {

  @OnCreateMountContent
  static CardClipDrawable onCreateMountContent(ComponentContext c) {
    return new CardClipDrawable();
  }

  @OnMount
  static void onMount(
      ComponentContext context,
      CardClipDrawable cardClipDrawable,
      @Prop(optional = true, resType = ResType.COLOR) int clippingColor,
      @Prop(optional = true, resType = ResType.DIMEN_OFFSET) float cornerRadius) {

    cardClipDrawable.setClippingColor(clippingColor);
    cardClipDrawable.setCornerRadius(cornerRadius);
  }
}
