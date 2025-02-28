# TextWithImage

[![](https://jitpack.io/v/joelnah/NahUtils.svg)](https://jitpack.io/#joelnah/NahUtils)

### Setting

```kotlin
//settings.gradle
maven(url = "https://jitpack.io")
//build.gradle
implementation ("com.github.joelnah:TextWithImage:Tag")
```

## 사용법

```kotlin
TextWithImage(
    text = "텍스트 뒤에 붙습니다. ",
){ fontSize -> //fontSize와 동일한 사이즈로 맞추고 싶을 때 사용합니다. 
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "icon",
        modifier = Modifier.size(fontSize.value.dp).background(MaterialTheme.colorScheme.primary)
    )
}

TextWithImage(
    text = "이미지를 붙이기 위해 만들었지만 그 외에 다른 컴포저블도 사용 가능합니다. ",
){
    Text(
        "subText",
        modifier = Modifier,
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.error
    )
}
```
