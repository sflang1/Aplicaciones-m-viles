Imports System
Imports System.Threading
Imports System.Windows.Controls
Imports Microsoft.Phone.Controls
Imports Microsoft.Phone.Shell

Partial Public Class MainPage
    Inherits PhoneApplicationPage

    ' Constructor
    Public Sub New()
        InitializeComponent()

        SupportedOrientations = SupportedPageOrientation.Portrait Or SupportedPageOrientation.Landscape

        ' Código de ejemplo para traducir ApplicationBar
        'BuildLocalizedApplicationBar()

    End Sub

    ' Código de ejemplo para compilar una ApplicationBar traducida
    'Private Sub BuildLocalizedApplicationBar()
    '    ' Establecer ApplicationBar de la página en una nueva instancia de ApplicationBar.
    '    ApplicationBar = New ApplicationBar()

    '    ' Crear un nuevo botón y establecer el valor de texto en la cadena traducida de AppResources.
    '    Dim appBarButton As New ApplicationBarIconButton(New Uri("/Assets/AppBar/appbar.add.rest.png", UriKind.Relative))
    '    appBarButton.Text = AppResources.AppBarButtonText
    '    ApplicationBar.Buttons.Add(appBarButton)

    '    ' Crear un nuevo elemento de menú con la cadena traducida de AppResources.
    '    Dim appBarMenuItem As New ApplicationBarMenuItem(AppResources.AppBarMenuItemText)
    '    ApplicationBar.MenuItems.Add(appBarMenuItem)
    'End Sub

    Private Sub ColorCheckbox(sender As Object, e As RoutedEventArgs)
        ' Se utilizarán binarios. Azul es el menos significativo, Verde el siguiente y Rojo el siguiente.
        ' Si hay azul, se suma un 1, si hay verde, se suma un 2, si hay rojo, se suma 4.
        Dim a As Integer = 0
        If (CheckboxAzul.IsChecked) Then
            a = a + 1
        End If
        If (CheckboxRojo.IsChecked) Then
            a = a + 4
        End If
        If (CheckboxVerde.IsChecked) Then
            a = a + 2
        End If
        Select Case a
            Case 0
                Rectangulo.Fill = New SolidColorBrush(Color.FromArgb(255, 0, 0, 0))
            Case 1
                Rectangulo.Fill = New SolidColorBrush(Color.FromArgb(255, 0, 0, 255))
            Case 2
                Rectangulo.Fill = New SolidColorBrush(Color.FromArgb(255, 0, 255, 0))
            Case 3
                Rectangulo.Fill = New SolidColorBrush(Color.FromArgb(255, 0, 255, 255))
            Case 4
                Rectangulo.Fill = New SolidColorBrush(Color.FromArgb(255, 255, 0, 0))
            Case 5
                Rectangulo.Fill = New SolidColorBrush(Color.FromArgb(255, 255, 0, 255))
            Case 6
                Rectangulo.Fill = New SolidColorBrush(Color.FromArgb(255, 255, 255, 0))
            Case 7
                Rectangulo.Fill = New SolidColorBrush(Color.FromArgb(255, 255, 255, 255))
            Case Else
                'error'
        End Select
    End Sub

    Private Sub ClickRadioButton(sender As Object, e As RoutedEventArgs)
        Dim a As Integer = 0
        ' Si hay azul, se suma un 1, si hay verde, se suma un 2, si hay rojo, se suma 4.
        If (RadioAzul.IsChecked) Then
            a = 1
        End If
        If (RadioRojo.IsChecked) Then
            a = 4
        End If
        If (RadioVerde.IsChecked) Then
            a = 2
        End If
        Select Case a
            Case 1
                Rectangulo.Fill = New SolidColorBrush(Color.FromArgb(255, 0, 0, 255))
            Case 2
                Rectangulo.Fill = New SolidColorBrush(Color.FromArgb(255, 0, 255, 0))
            Case 4
                Rectangulo.Fill = New SolidColorBrush(Color.FromArgb(255, 255, 0, 0))
            Case Else
                'error'
        End Select
    End Sub
End Class