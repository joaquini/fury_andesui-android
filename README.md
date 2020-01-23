# Andes UI library
[![CircleCI](https://circleci.com/gh/mercadolibre/fury_andesui-android/tree/develop.svg?style=svg&circle-token=8e02fdc4da02d2d807c6ebf81b15a49a25d3ebbe)](https://github.com/mercadolibre/fury_andesui-android)

## What is this?

This is the Android library of Andes.
Andes is the design language used at Mercado Libre.

## How to use?

You can include this module by adding the dependency to your build.gradle file.

```
implementation com.mercadolibre.android.andesui:components:X.Y.Z
```

### Latest version
[ ![Download](https://api.bintray.com/packages/mercadolibre/android-public/com.mercadolibre.android.andesui.components/images/download.svg?version=1.0.0) ](https://bintray.com/mercadolibre/android-public/com.mercadolibre.android.andesui.components/1.0.0/link)

## Useful links

* [Components](https://github.com/mercadolibre/fury_andesui-android/wiki#components)
* [Contributing](https://github.com/mercadolibre/fury_andesui-android/blob/develop/CONTRIBUTING.md)

## Example

This repo contains a [demo application](https://github.com/mercadolibre/fury_andesui-android/tree/develop/demoapp) with examples about how to use the different widgets available in the library.

## Architecture

![Andes UI](https://user-images.githubusercontent.com/51792499/72842980-60714700-3c78-11ea-86bd-83281b1f6bcf.png)

If you want to know more about it, you can watch this [explanation video](https://drive.google.com/file/d/1a8KBwlILW-JOnrO8cEGuQ7CNYSORJg4A/view)

## Considerations

* All components were thought to follow similar implementation patterns, make sure you familiarize with a few of them before implementing a new one, you should follow the same methodologies as the previous components.
* Each component should have an entry on the wiki, if you are adding or updating one, please add the changes to the related entry.
* Bugs or feature requests should be submitted at our GitHub Issues section.

## Requirements

This library needs Android API 19+ (4.4+) to work.

## How to make a local publish

``
./gradlew build publishToMavenLocal
``

Pro tip: First change the version name in gradle.properties to X.XX.X-LOCAL (Note that we use [SemVer](https://semver.org/)).

## DON'Ts

We’re aligned with [these concepts](https://proandroiddev.com/how-to-maximize-androids-ui-reusability-5-common-mistakes-cb2571216a9f). Please be sure to follow them:
* Avoid using Business Models inside custom views.
* Avoid monolithic views.
* Avoid business logic in custom views.
* Avoid over-optimization (readable code is better than optimized code!)
* Avoid neglecting our UI in code reviews.


## Author

Mercado Libre.

## License

AndesUI is available under the MIT license. See the LICENSE file for more info.

